package takingdatafromweb;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class TakingDataFromWeb {

    public static void main(String[] args) throws IOException {
        List<Gas> stations = new ArrayList<>();
        getStations(stations);
        writeStationsToFile(stations, "stationsAuto.txt");
    }
    
    public static void getStations(List<Gas> stations) throws IOException{
        nesteGas(stations);
        orlenGas(stations);
        lukoilLuktarna(stations);
        bpGas(stations);
        jozitaGas(stations);
    }
    
    public static void writeStationsToFile(List<Gas> stations, String filename) throws IOException{
        try (BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(filename), "utf-8"))) {
            for (int i = 0; i < stations.size(); i++) {
                writer.write(stations.get(i).toString());
                writer.newLine();
            }
        }
    }
    
    public static void nesteGas(List<Gas> stations) throws IOException{
        String url="https://www.neste.lt/lt/node/1009";
        Document document = Jsoup.connect(url).get();
        Element table = document.select(".field-items table").get(0);
        Elements rows = table.select("tr");

        String food="iVBORw0KGgoAAAANSUhEUgAAABQAAAATCAIAAAAf7rriAAAB7klEQVQ4jbWUO6viQBiGz0+OQeJcdCIoioU3gl2MiVERQRELYwSjeEHsBFOKhWhnIRoVJEy2mN0o2V3PNvtVw8M8M5k338yX96sopZRS761+Jwz6468APR6Puq53u13HcRi/3++GYbTb7dPp9FeZla7roVCI5/nFYsHIfD7neZ7juFarFZgclGVZBgBEIpHRaMRIv98XBAEAUC6Xv5EVRWHyZDJhZDAYRCIRAICqqv9TVlWVyfP5nJHhcMjkarUalFl6rutut9v1ei1JEsYYIdRsNjebjW3buq5jjDHGkiSt12vbth+Ph+d5lNKfO89mM4QQhJAQEo/HRVGMRqMIIYRQLBYTRVEURUIIhFAQhGaz6bru67NrtRrHcQghQgibGo1GIYQBGWMcDoczmcztdnvJu92uVCpls9lEIkEIIYSk0+lisVgoFFKpFCPJZDKXy+Xz+dVqFQzs+XxeLhdZliGEAADTNB3HcRyn1+sBACCE5XL5er2yA78Ce+9hP+3pdMqIaZosbU3T3qOmlAblSqXC5PF4zIhhGH/8z6+0/WJNAgDw5X9tEkqp39uWZTHY7/fZcoqifJI9z6vX6xzH8Ty/XC4ZsSwrFApxHFer1b6RD4eDpmmdTse/z+fzudFoyLK83++9z/c5cIrPb8sP3U2i6IgTuUEAAAAASUVORK5CYII";
        String carwash="iVBORw0KGgoAAAANSUhEUgAAABYAAAAUCAIAAAAGHlpnAAACHElEQVQ4jZWTS8/xQBSA/WJxqdKRqMSGjYWwIOoavNooYcMCO9VSIRFNkTYiaYIEC+JWnW/RxOv2+uLZzjnPnHPmjAF+RFXV0+n0Ocbw14GmaRzHBQIBv9/faDQul8vXCp7nEQQxmUwmk8loNNbr9a8VnU6HJMlisVgoFHK5XLPZ1DTtC4WmaefzeTabKYqyWCwkSToej19XIYoiwzA8z/f7fY7jRqPRdwpVVWu12mq16vV6vV5vvV5Xq9W/Jvqg0DRNb/hwOAwGAwihJEmSJEEI+/3+bre7j3mvuF6v+rEsywzDdLtdjuNYluV5nmGYyWRyu+lTFRDC+Xwej8dbrVbnDpZlE4mEXtF/ZnE4HAiCGI/Hr6GyLBMEsd/vn640PLVH03SpVIIQqqp6fQRCWKlUaJp+Gpzhlrzdbsvlss1mCwaD6XQ68UI6nQ6FQjabrVgsbjab30ZuCoqiEAQJh8M+nw9FUewFu93u9XojkQiCILlc7pb4qyAIwu/3QwhFUcQwDH/E5XJhGDYcDiGEgUAgHA6/UWQyGRzH2+02TdMAAPwFp9OZz+dZlnW73clk8k0j2WzWbDY7HA4MwwAAjhcAAAAAu91usVhSqdQbxXQ6jUajAACXy0UQBEmSP3dQFBWLxfR2IpGI/uoPj6pbJpMJiqI4jiuK8roXy+XS4/FYrVZBEB724n5bL5eLKIpvV1BHlmVBEPT/dkv8BzdZcuH3RNzLAAAAAElFTkSuQmCC";

        for (int j = 1; j < rows.size(); j++) {
            Element row=rows.get(j);
            Elements cols = row.select("td");
            String[] parametrai=new String[6];
            parametrai[0]=cols.get(0).text();  //miestas
            parametrai[1]=cols.get(1).text();  //pavadinimas
            parametrai[2]=cols.get(2).text();  //adresas
            parametrai[5]=row.select("[src]").toString();  //paslaugos
            String spliting="<img alt=\"\" ";
            String[] parts=parametrai[5].split(spliting);
            if(parts.length==0){
                parts[0]=parametrai[5];
            }
            String adresas=parametrai[2]+", "+parametrai[0];
            String foodBool="false";
            String airBool="false";
            String carwashBool="false";
            for (String choose : parts) {
               if (choose.contains(food))
                   foodBool="true";
               if (choose.contains(carwash))
                   carwashBool="true";
            }
            Gas station = new Gas(parametrai[1], adresas, foodBool, airBool, carwashBool);
            stations.add(station);
            //System.out.println(station.toString());
        }
    }
    
    public static void orlenGas(List<Gas> stations) throws IOException{
        String url="http://degalines.orlenlietuva.lt/lt/main/stations";
        Document document = Jsoup.connect(url).get();
        Element table = document.select(".tabela01").get(0);
        Elements rows = table.select("tr");
        for (int j = 0; j < rows.size(); j++) { 
            Element row=rows.get(j);
            Elements cols = row.select("td");
            String adresas=cols.text();
            adresas=adresas.replace("–", "-");
            adresas=adresas.replace("-T", "- T");
            String spliting="- Tel.";
            String[] parts=adresas.split(spliting);
            String foodBool="true";
            String airBool="true";
            String carwashBool="true";
            String adress="null";
            for (int i = 0; i < parts.length; i++) {
                if(parts[i].startsWith(" +")){
                    try{
                        parts[i]=parts[i].substring(18);
                        if(parts[i].charAt(parts[i].length()-1)==' ' || parts[i].charAt(parts[i].length()-1)==',')
                            parts[i]=parts[i].substring(0,parts[i].length()-1);
                        adress = parts[i];
                        Gas station = new Gas("Orlen", adress, foodBool, airBool, carwashBool);
                        stations.add(station);
                        //System.out.println(station.toString());
                    }
                    catch (Exception e){
                        
                    }
                }
                else{
                    if(parts[i].charAt(parts[i].length()-1)==' ' || parts[i].charAt(parts[i].length()-1)==',')
                            parts[i]=parts[i].substring(0,parts[i].length()-1);
                    adress = parts[i];
                    Gas station = new Gas("Orlen", adress, foodBool, airBool, carwashBool);
                    stations.add(station);
                    //System.out.println(station.toString());
                }
                
                
            }
        }
    }
    
    public static void bpGas(List<Gas> stations) throws IOException{
        String url="http://balticpetroleum.lt/baltic-petroleum-degalines";
        String food="/uploads/images/ikonos/uzkandziai.png";
        String air="/uploads/images/ikonos/orasvanduo.png";
        String carwash="/uploads/images/ikonos/plovykla.png";
        Document document = Jsoup.connect(url).get();
        Element table = document.select(".degalines").get(0);
        Elements rows = table.select("tr");
        for (int i = 1; i < rows.size(); i++){
            Element row = rows.get(i);
            Elements cols = row.select("td");
            String adress = cols.get(1).toString();
            String city = adress.substring(adress.indexOf("<strong>")+8, adress.indexOf("</strong>"));
            String adresas = adress.substring(adress.indexOf("</strong>")+9, adress.indexOf("</td>")).trim();
            String fullAdress = adresas+", "+city;
            String options = cols.select("[src]").toString();
            String foodBool = "false";
            String airBool = "false";
            String carwashBool = "false";
            String[] optionSplit = options.split("<img src=");
            for (String part : optionSplit){
                if (part.contains(food))
                    foodBool = "true";
                if (part.contains(air))
                    airBool = "true";
                if (part.contains(carwash))
                    carwashBool = "true";
            }
            Gas station = new Gas("Baltic Petroleum", fullAdress, foodBool, airBool, carwashBool);
            stations.add(station);
            //System.out.println(station.toString());
        }
    }
    
    public static void jozitaGas(List<Gas> stations) throws IOException{
        String url="http://jozita.lt/kontaktai";
        Document document = Jsoup.connect(url).get();
        Element table = document.select(".content").get(1);
        Elements rows = table.select("p");
        for (int i = 2; i < rows.size(); i++){
            String tekstas = rows.get(i).text();
            String[] parts = tekstas.split(":");
            String adresas;
            String foodBool = "false";
            String carwashBool = "false";
            String airBool = "false";
            if (parts[0].contains("Degalinė")){
                if (parts[1].indexOf("Tel") != -1)
                    adresas = parts[1].substring(0, parts[1].indexOf("Tel")).trim();
                else
                    adresas = parts[1].substring(0, parts[1].indexOf("Vadovo")).trim();
                if (parts[0].contains("arduotuvė"))
                    foodBool = "true";
                if (parts[0].contains("lovykla"))
                    carwashBool = "true";
                Gas station = new Gas("Jozita", adresas, foodBool, airBool, carwashBool);
                stations.add(station);
                //System.out.println(station.toString());
            }
        }
    }
    
    public static void lukoilLuktarna(List<Gas> stations) throws IOException{
        String url="http://www.viada.lt/degalines/informacija-apie-degalines/";
        Document document = Jsoup.connect(url).get();
        Elements rows = document.select(".table tbody tr");
        //Elements rows = table.select("tr");
        for (int j = 0; j < rows.size(); j++) {
            if(rows.get(j).text().length()>100){
                Element row=rows.get(j);
                Elements cols = row.select("td");
                String[] parametrai=new String[6];
                parametrai[0]=cols.get(0).text();  //miestas
                if(cols.get(1).toString().contains("lukoil")==true)
                    parametrai[1]="Lukoil";
                else if(cols.get(1).toString().contains("luktarna")==true)
                    parametrai[1]="Lukatarna";
                else
                    parametrai[1]="Viada";
                parametrai[2]=cols.get(4).toString().contains("Parduotuvė")==true ? "true" : "false";
                parametrai[3]=cols.get(4).toString().contains("Oro")==true ? "true" : "false";
                parametrai[4]=cols.get(4).toString().contains("Plovykla")==true ? "true" : "false";
                Gas station = new Gas(parametrai[1], parametrai[0], parametrai[2], parametrai[3], parametrai[4]);
                stations.add(station);
                //System.out.println(station.toString());
            }
        }
    }
}
