package takingdatafromweb;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
public class TakingDataFromWeb {

    public static void main(String[] args) throws IOException {
       // nesteGas();
       // orlenGas();
       // lukoilGas();
       // bpGas();
       // jozitaGas();
       // luktarnaGas();
    }
    
    public static void nesteGas() throws IOException{
        String url="https://www.neste.lt/lt/node/1009";
        Document document = Jsoup.connect(url).get();
        Elements gases=document.select(".field-items table tbody tr");
        Elements media=document.select(".field-items table tbody tr [src]");
        Elements med=document.select(".field-items table tbody tr p");
        Element table = document.select(".field-items table").get(0);
        Elements rows = table.select("tr");

        String food="src=\"data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAABQAAAATCAIAAAAf7rriAAAB7klEQVQ4jbWUO6viQBiGz0+OQeJcdCIoioU3gl2MiVERQRELYwSjeEHsBFOKhWhnIRoVJEy2mN0o2V3PNvtVw8M8M5k338yX96sopZRS761+Jwz6468APR6Puq53u13HcRi/3++GYbTb7dPp9FeZla7roVCI5/nFYsHIfD7neZ7juFarFZgclGVZBgBEIpHRaMRIv98XBAEAUC6Xv5EVRWHyZDJhZDAYRCIRAICqqv9TVlWVyfP5nJHhcMjkarUalFl6rutut9v1ei1JEsYYIdRsNjebjW3buq5jjDHGkiSt12vbth+Ph+d5lNKfO89mM4QQhJAQEo/HRVGMRqMIIYRQLBYTRVEURUIIhFAQhGaz6bru67NrtRrHcQghQgibGo1GIYQBGWMcDoczmcztdnvJu92uVCpls9lEIkEIIYSk0+lisVgoFFKpFCPJZDKXy+Xz+dVqFQzs+XxeLhdZliGEAADTNB3HcRyn1+sBACCE5XL5er2yA78Ce+9hP+3pdMqIaZosbU3T3qOmlAblSqXC5PF4zIhhGH/8z6+0/WJNAgDw5X9tEkqp39uWZTHY7/fZcoqifJI9z6vX6xzH8Ty/XC4ZsSwrFApxHFer1b6RD4eDpmmdTse/z+fzudFoyLK83++9z/c5cIrPb8sP3U2i6IgTuUEAAAAASUVORK5CYII=\">\n";
        String food1="src=\"data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAABQAAAATCAIAAAAf7rriAAAB7klEQVQ4jbWUO6viQBiGz0+OQeJcdCIoioU3gl2MiVERQRELYwSjeEHsBFOKhWhnIRoVJEy2mN0o2V3PNvtVw8M8M5k338yX96sopZRS761+Jwz6468APR6Puq53u13HcRi/3++GYbTb7dPp9FeZla7roVCI5/nFYsHIfD7neZ7juFarFZgclGVZBgBEIpHRaMRIv98XBAEAUC6Xv5EVRWHyZDJhZDAYRCIRAICqqv9TVlWVyfP5nJHhcMjkarUalFl6rutut9v1ei1JEsYYIdRsNjebjW3buq5jjDHGkiSt12vbth+Ph+d5lNKfO89mM4QQhJAQEo/HRVGMRqMIIYRQLBYTRVEURUIIhFAQhGaz6bru67NrtRrHcQghQgibGo1GIYQBGWMcDoczmcztdnvJu92uVCpls9lEIkEIIYSk0+lisVgoFFKpFCPJZDKXy+Xz+dVqFQzs+XxeLhdZliGEAADTNB3HcRyn1+sBACCE5XL5er2yA78Ce+9hP+3pdMqIaZosbU3T3qOmlAblSqXC5PF4zIhhGH/8z6+0/WJNAgDw5X9tEkqp39uWZTHY7/fZcoqifJI9z6vX6xzH8Ty/XC4ZsSwrFApxHFer1b6RD4eDpmmdTse/z+fzudFoyLK83++9z/c5cIrPb8sP3U2i6IgTuUEAAAAASUVORK5CYII=\"> ";
        String food2="src=\"data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAABQAAAATCAIAAAAf7rriAAAB7klEQVQ4jbWUO6viQBiGz0+OQeJcdCIoioU3gl2MiVERQRELYwSjeEHsBFOKhWhnIRoVJEy2mN0o2V3PNvtVw8M8M5k338yX96sopZRS761+Jwz6468APR6Puq53u13HcRi/3++GYbTb7dPp9FeZla7roVCI5/nFYsHIfD7neZ7juFarFZgclGVZBgBEIpHRaMRIv98XBAEAUC6Xv5EVRWHyZDJhZDAYRCIRAICqqv9TVlWVyfP5nJHhcMjkarUalFl6rutut9v1ei1JEsYYIdRsNjebjW3buq5jjDHGkiSt12vbth+Ph+d5lNKfO89mM4QQhJAQEo/HRVGMRqMIIYRQLBYTRVEURUIIhFAQhGaz6bru67NrtRrHcQghQgibGo1GIYQBGWMcDoczmcztdnvJu92uVCpls9lEIkEIIYSk0+lisVgoFFKpFCPJZDKXy+Xz+dVqFQzs+XxeLhdZliGEAADTNB3HcRyn1+sBACCE5XL5er2yA78Ce+9hP+3pdMqIaZosbU3T3qOmlAblSqXC5PF4zIhhGH/8z6+0/WJNAgDw5X9tEkqp39uWZTHY7/fZcoqifJI9z6vX6xzH8Ty/XC4ZsSwrFApxHFer1b6RD4eDpmmdTse/z+fzudFoyLK83++9z/c5cIrPb8sP3U2i6IgTuUEAAAAASUVORK5CYII=\" style=\"line-height:20.8px\">";
        String food3="src=\"data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAABQAAAATCAIAAAAf7rriAAAB7klEQVQ4jbWUO6viQBiGz0+OQeJcdCIoioU3gl2MiVERQRELYwSjeEHsBFOKhWhnIRoVJEy2mN0o2V3PNvtVw8M8M5k338yX96sopZRS761+Jwz6468APR6Puq53u13HcRi/3++GYbTb7dPp9FeZla7roVCI5/nFYsHIfD7neZ7juFarFZgclGVZBgBEIpHRaMRIv98XBAEAUC6Xv5EVRWHyZDJhZDAYRCIRAICqqv9TVlWVyfP5nJHhcMjkarUalFl6rutut9v1ei1JEsYYIdRsNjebjW3buq5jjDHGkiSt12vbth+Ph+d5lNKfO89mM4QQhJAQEo/HRVGMRqMIIYRQLBYTRVEURUIIhFAQhGaz6bru67NrtRrHcQghQgibGo1GIYQBGWMcDoczmcztdnvJu92uVCpls9lEIkEIIYSk0+lisVgoFFKpFCPJZDKXy+Xz+dVqFQzs+XxeLhdZliGEAADTNB3HcRyn1+sBACCE5XL5er2yA78Ce+9hP+3pdMqIaZosbU3T3qOmlAblSqXC5PF4zIhhGH/8z6+0/WJNAgDw5X9tEkqp39uWZTHY7/fZcoqifJI9z6vX6xzH8Ty/XC4ZsSwrFApxHFer1b6RD4eDpmmdTse/z+fzudFoyLK83++9z/c5cIrPb8sP3U2i6IgTuUEAAAAASUVORK5CYII=\">";
        String food4="src=\"data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAABQAAAATCAIAAAAf7rriAAAB7klEQVQ4jbWUO6viQBiGz0+OQeJcdCIoioU3gl2MiVERQRELYwSjeEHsBFOKhWhnIRoVJEy2mN0o2V3PNvtVw8M8M5k338yX96sopZRS761+Jwz6468APR6Puq53u13HcRi/3++GYbTb7dPp9FeZla7roVCI5/nFYsHIfD7neZ7juFarFZgclGVZBgBEIpHRaMRIv98XBAEAUC6Xv5EVRWHyZDJhZDAYRCIRAICqqv9TVlWVyfP5nJHhcMjkarUalFl6rutut9v1ei1JEsYYIdRsNjebjW3buq5jjDHGkiSt12vbth+Ph+d5lNKfO89mM4QQhJAQEo/HRVGMRqMIIYRQLBYTRVEURUIIhFAQhGaz6bru67NrtRrHcQghQgibGo1GIYQBGWMcDoczmcztdnvJu92uVCpls9lEIkEIIYSk0+lisVgoFFKpFCPJZDKXy+Xz+dVqFQzs+XxeLhdZliGEAADTNB3HcRyn1+sBACCE5XL5er2yA78Ce+9hP+3pdMqIaZosbU3T3qOmlAblSqXC5PF4zIhhGH/8z6+0/WJNAgDw5X9tEkqp39uWZTHY7/fZcoqifJI9z6vX6xzH8Ty/XC4ZsSwrFApxHFer1b6RD4eDpmmdTse/z+fzudFoyLK83++9z/c5cIrPb8sP3U2i6IgTuUEAAAAASUVORK5CYII=\" style=\"line-height:20.8px\">\n";
        String shower="src=\"data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAABYAAAAUCAIAAAAGHlpnAAACHElEQVQ4jZWTS8/xQBSA/WJxqdKRqMSGjYWwIOoavNooYcMCO9VSIRFNkTYiaYIEC+JWnW/RxOv2+uLZzjnPnHPmjAF+RFXV0+n0Ocbw14GmaRzHBQIBv9/faDQul8vXCp7nEQQxmUwmk8loNNbr9a8VnU6HJMlisVgoFHK5XLPZ1DTtC4WmaefzeTabKYqyWCwkSToej19XIYoiwzA8z/f7fY7jRqPRdwpVVWu12mq16vV6vV5vvV5Xq9W/Jvqg0DRNb/hwOAwGAwihJEmSJEEI+/3+bre7j3mvuF6v+rEsywzDdLtdjuNYluV5nmGYyWRyu+lTFRDC+Xwej8dbrVbnDpZlE4mEXtF/ZnE4HAiCGI/Hr6GyLBMEsd/vn640PLVH03SpVIIQqqp6fQRCWKlUaJp+Gpzhlrzdbsvlss1mCwaD6XQ68UI6nQ6FQjabrVgsbjab30ZuCoqiEAQJh8M+nw9FUewFu93u9XojkQiCILlc7pb4qyAIwu/3QwhFUcQwDH/E5XJhGDYcDiGEgUAgHA6/UWQyGRzH2+02TdMAAPwFp9OZz+dZlnW73clk8k0j2WzWbDY7HA4MwwAAjhcAAAAAu91usVhSqdQbxXQ6jUajAACXy0UQBEmSP3dQFBWLxfR2IpGI/uoPj6pbJpMJiqI4jiuK8roXy+XS4/FYrVZBEB724n5bL5eLKIpvV1BHlmVBEPT/dkv8BzdZcuH3RNzLAAAAAElFTkSuQmCC\">";
        String shower1="src=\"data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAABYAAAAUCAIAAAAGHlpnAAACHElEQVQ4jZWTS8/xQBSA/WJxqdKRqMSGjYWwIOoavNooYcMCO9VSIRFNkTYiaYIEC+JWnW/RxOv2+uLZzjnPnHPmjAF+RFXV0+n0Ocbw14GmaRzHBQIBv9/faDQul8vXCp7nEQQxmUwmk8loNNbr9a8VnU6HJMlisVgoFHK5XLPZ1DTtC4WmaefzeTabKYqyWCwkSToej19XIYoiwzA8z/f7fY7jRqPRdwpVVWu12mq16vV6vV5vvV5Xq9W/Jvqg0DRNb/hwOAwGAwihJEmSJEEI+/3+bre7j3mvuF6v+rEsywzDdLtdjuNYluV5nmGYyWRyu+lTFRDC+Xwej8dbrVbnDpZlE4mEXtF/ZnE4HAiCGI/Hr6GyLBMEsd/vn640PLVH03SpVIIQqqp6fQRCWKlUaJp+Gpzhlrzdbsvlss1mCwaD6XQ68UI6nQ6FQjabrVgsbjab30ZuCoqiEAQJh8M+nw9FUewFu93u9XojkQiCILlc7pb4qyAIwu/3QwhFUcQwDH/E5XJhGDYcDiGEgUAgHA6/UWQyGRzH2+02TdMAAPwFp9OZz+dZlnW73clk8k0j2WzWbDY7HA4MwwAAjhcAAAAAu91usVhSqdQbxXQ6jUajAACXy0UQBEmSP3dQFBWLxfR2IpGI/uoPj6pbJpMJiqI4jiuK8roXy+XS4/FYrVZBEB724n5bL5eLKIpvV1BHlmVBEPT/dkv8BzdZcuH3RNzLAAAAAElFTkSuQmCC\" style=\"line-height:20.8px\">";
        String shower2="src=\"data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAABYAAAAUCAIAAAAGHlpnAAACHElEQVQ4jZWTS8/xQBSA/WJxqdKRqMSGjYWwIOoavNooYcMCO9VSIRFNkTYiaYIEC+JWnW/RxOv2+uLZzjnPnHPmjAF+RFXV0+n0Ocbw14GmaRzHBQIBv9/faDQul8vXCp7nEQQxmUwmk8loNNbr9a8VnU6HJMlisVgoFHK5XLPZ1DTtC4WmaefzeTabKYqyWCwkSToej19XIYoiwzA8z/f7fY7jRqPRdwpVVWu12mq16vV6vV5vvV5Xq9W/Jvqg0DRNb/hwOAwGAwihJEmSJEEI+/3+bre7j3mvuF6v+rEsywzDdLtdjuNYluV5nmGYyWRyu+lTFRDC+Xwej8dbrVbnDpZlE4mEXtF/ZnE4HAiCGI/Hr6GyLBMEsd/vn640PLVH03SpVIIQqqp6fQRCWKlUaJp+Gpzhlrzdbsvlss1mCwaD6XQ68UI6nQ6FQjabrVgsbjab30ZuCoqiEAQJh8M+nw9FUewFu93u9XojkQiCILlc7pb4qyAIwu/3QwhFUcQwDH/E5XJhGDYcDiGEgUAgHA6/UWQyGRzH2+02TdMAAPwFp9OZz+dZlnW73clk8k0j2WzWbDY7HA4MwwAAjhcAAAAAu91usVhSqdQbxXQ6jUajAACXy0UQBEmSP3dQFBWLxfR2IpGI/uoPj6pbJpMJiqI4jiuK8roXy+XS4/FYrVZBEB724n5bL5eLKIpvV1BHlmVBEPT/dkv8BzdZcuH3RNzLAAAAAElFTkSuQmCC\">\n";
        String shower3="src=\"data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAABYAAAAUCAIAAAAGHlpnAAACHElEQVQ4jZWTS8/xQBSA/WJxqdKRqMSGjYWwIOoavNooYcMCO9VSIRFNkTYiaYIEC+JWnW/RxOv2+uLZzjnPnHPmjAF+RFXV0+n0Ocbw14GmaRzHBQIBv9/faDQul8vXCp7nEQQxmUwmk8loNNbr9a8VnU6HJMlisVgoFHK5XLPZ1DTtC4WmaefzeTabKYqyWCwkSToej19XIYoiwzA8z/f7fY7jRqPRdwpVVWu12mq16vV6vV5vvV5Xq9W/Jvqg0DRNb/hwOAwGAwihJEmSJEEI+/3+bre7j3mvuF6v+rEsywzDdLtdjuNYluV5nmGYyWRyu+lTFRDC+Xwej8dbrVbnDpZlE4mEXtF/ZnE4HAiCGI/Hr6GyLBMEsd/vn640PLVH03SpVIIQqqp6fQRCWKlUaJp+Gpzhlrzdbsvlss1mCwaD6XQ68UI6nQ6FQjabrVgsbjab30ZuCoqiEAQJh8M+nw9FUewFu93u9XojkQiCILlc7pb4qyAIwu/3QwhFUcQwDH/E5XJhGDYcDiGEgUAgHA6/UWQyGRzH2+02TdMAAPwFp9OZz+dZlnW73clk8k0j2WzWbDY7HA4MwwAAjhcAAAAAu91usVhSqdQbxXQ6jUajAACXy0UQBEmSP3dQFBWLxfR2IpGI/uoPj6pbJpMJiqI4jiuK8roXy+XS4/FYrVZBEB724n5bL5eLKIpvV1BHlmVBEPT/dkv8BzdZcuH3RNzLAAAAAElFTkSuQmCC\"> ";
        String shower4="src=\"data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAABYAAAAUCAIAAAAGHlpnAAACHElEQVQ4jZWTS8/xQBSA/WJxqdKRqMSGjYWwIOoavNooYcMCO9VSIRFNkTYiaYIEC+JWnW/RxOv2+uLZzjnPnHPmjAF+RFXV0+n0Ocbw14GmaRzHBQIBv9/faDQul8vXCp7nEQQxmUwmk8loNNbr9a8VnU6HJMlisVgoFHK5XLPZ1DTtC4WmaefzeTabKYqyWCwkSToej19XIYoiwzA8z/f7fY7jRqPRdwpVVWu12mq16vV6vV5vvV5Xq9W/Jvqg0DRNb/hwOAwGAwihJEmSJEEI+/3+bre7j3mvuF6v+rEsywzDdLtdjuNYluV5nmGYyWRyu+lTFRDC+Xwej8dbrVbnDpZlE4mEXtF/ZnE4HAiCGI/Hr6GyLBMEsd/vn640PLVH03SpVIIQqqp6fQRCWKlUaJp+Gpzhlrzdbsvlss1mCwaD6XQ68UI6nQ6FQjabrVgsbjab30ZuCoqiEAQJh8M+nw9FUewFu93u9XojkQiCILlc7pb4qyAIwu/3QwhFUcQwDH/E5XJhGDYcDiGEgUAgHA6/UWQyGRzH2+02TdMAAPwFp9OZz+dZlnW73clk8k0j2WzWbDY7HA4MwwAAjhcAAAAAu91usVhSqdQbxXQ6jUajAACXy0UQBEmSP3dQFBWLxfR2IpGI/uoPj6pbJpMJiqI4jiuK8roXy+XS4/FYrVZBEB724n5bL5eLKIpvV1BHlmVBEPT/dkv8BzdZcuH3RNzLAAAAAElFTkSuQmCC\" style=\"line-height:20.8px\">\n";
        String foodMarket ="src=\"data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAABQAAAATCAIAAAAf7rriAAACbklEQVQ4jZWUS0/qQBSA/cWuDCEmkJZeKSYMlILWhYG+JkJ4JCwwRh59mCJpWBgXYPCV1Kg8KhETN1B67qKISDTX+60mM+fLzJlzZjZc13VdFz5YHf+TDS96PB4bhjGdTn9vAsAGALTbbZZlA4HA8/Pzf8v1ej2RSASDwcvLy9+brusujj2fz/f392OxmCiKkiRhjAVBwBjLsszzPMZYFEVRFDHGPM/Lsnx/fw/LnAGgWCySJFkqldLpdDgcLhaL8Xg8kUiUSiWapnme53k+Eolks9nt7W1d1xey52uaxjAMADw+PsqyDACNRkPTNAA4OjoajUbD4TCXywEAQujs7GyRs0ev1wuFQoVCQZIkhFC5XN7b2+M4rlwuI4S8FBBC+XyeJMlms7mQl9Xa2dnJ5/PHx8csyzabzUwmIwjC+fl5MpmsVCqVSiWVSqmqSlGUYRhfdp7NZizLGobR7/clSfKqoKoqAGCM+/3+YDDIZrOO40Sj0UXOq7dfKBQoiorH4wRBcBwXDodpmuY4jiAIhmEYhiFJMplM+v3+Vqu1Luu6HggETk5OdF2vVquKoiiKUq1WVVWt1+u1Wk3TtNPTU0VRJpPJutzpdILBoGmavV7v6ju63e7Nzc1nk6zKk8kklUpRFBWJRP58haZpmqZDodDu7q7XxesyALy/v1uWdXt7a9v26APbth8eHizLenl5sW17Pp97wZ+yV7DpdCoIAkLo6elpufT29nZ4eHhwcPD6+rq607o8Ho9Jktzc3Ly4uFhO3t3d+Xy+ra2t6+vr7+Ul3W7XNE3vbXuy4zimabZaLcdxfpTXvhH3g59i/gLwmMRO20VmwgAAAABJRU5ErkJggg==\">"; 
        String foodMarket1 ="src=\"data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAABQAAAATCAIAAAAf7rriAAACbklEQVQ4jZWUS0/qQBSA/cWuDCEmkJZeKSYMlILWhYG+JkJ4JCwwRh59mCJpWBgXYPCV1Kg8KhETN1B67qKISDTX+60mM+fLzJlzZjZc13VdFz5YHf+TDS96PB4bhjGdTn9vAsAGALTbbZZlA4HA8/Pzf8v1ej2RSASDwcvLy9+brusujj2fz/f392OxmCiKkiRhjAVBwBjLsszzPMZYFEVRFDHGPM/Lsnx/fw/LnAGgWCySJFkqldLpdDgcLhaL8Xg8kUiUSiWapnme53k+Eolks9nt7W1d1xey52uaxjAMADw+PsqyDACNRkPTNAA4OjoajUbD4TCXywEAQujs7GyRs0ev1wuFQoVCQZIkhFC5XN7b2+M4rlwuI4S8FBBC+XyeJMlms7mQl9Xa2dnJ5/PHx8csyzabzUwmIwjC+fl5MpmsVCqVSiWVSqmqSlGUYRhfdp7NZizLGobR7/clSfKqoKoqAGCM+/3+YDDIZrOO40Sj0UXOq7dfKBQoiorH4wRBcBwXDodpmuY4jiAIhmEYhiFJMplM+v3+Vqu1Luu6HggETk5OdF2vVquKoiiKUq1WVVWt1+u1Wk3TtNPTU0VRJpPJutzpdILBoGmavV7v6ju63e7Nzc1nk6zKk8kklUpRFBWJRP58haZpmqZDodDu7q7XxesyALy/v1uWdXt7a9v26APbth8eHizLenl5sW17Pp97wZ+yV7DpdCoIAkLo6elpufT29nZ4eHhwcPD6+rq607o8Ho9Jktzc3Ly4uFhO3t3d+Xy+ra2t6+vr7+Ul3W7XNE3vbXuy4zimabZaLcdxfpTXvhH3g59i/gLwmMRO20VmwgAAAABJRU5ErkJggg==\" style=\"line-height:20.8px\">";
        String foodMarket2 ="src=\"data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAABQAAAATCAIAAAAf7rriAAACbklEQVQ4jZWUS0/qQBSA/cWuDCEmkJZeKSYMlILWhYG+JkJ4JCwwRh59mCJpWBgXYPCV1Kg8KhETN1B67qKISDTX+60mM+fLzJlzZjZc13VdFz5YHf+TDS96PB4bhjGdTn9vAsAGALTbbZZlA4HA8/Pzf8v1ej2RSASDwcvLy9+brusujj2fz/f392OxmCiKkiRhjAVBwBjLsszzPMZYFEVRFDHGPM/Lsnx/fw/LnAGgWCySJFkqldLpdDgcLhaL8Xg8kUiUSiWapnme53k+Eolks9nt7W1d1xey52uaxjAMADw+PsqyDACNRkPTNAA4OjoajUbD4TCXywEAQujs7GyRs0ev1wuFQoVCQZIkhFC5XN7b2+M4rlwuI4S8FBBC+XyeJMlms7mQl9Xa2dnJ5/PHx8csyzabzUwmIwjC+fl5MpmsVCqVSiWVSqmqSlGUYRhfdp7NZizLGobR7/clSfKqoKoqAGCM+/3+YDDIZrOO40Sj0UXOq7dfKBQoiorH4wRBcBwXDodpmuY4jiAIhmEYhiFJMplM+v3+Vqu1Luu6HggETk5OdF2vVquKoiiKUq1WVVWt1+u1Wk3TtNPTU0VRJpPJutzpdILBoGmavV7v6ju63e7Nzc1nk6zKk8kklUpRFBWJRP58haZpmqZDodDu7q7XxesyALy/v1uWdXt7a9v26APbth8eHizLenl5sW17Pp97wZ+yV7DpdCoIAkLo6elpufT29nZ4eHhwcPD6+rq607o8Ho9Jktzc3Ly4uFhO3t3d+Xy+ra2t6+vr7+Ul3W7XNE3vbXuy4zimabZaLcdxfpTXvhH3g59i/gLwmMRO20VmwgAAAABJRU5ErkJggg==\">\n"; 
        String foodMarket3 ="src=\"data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAABQAAAATCAIAAAAf7rriAAACbklEQVQ4jZWUS0/qQBSA/cWuDCEmkJZeKSYMlILWhYG+JkJ4JCwwRh59mCJpWBgXYPCV1Kg8KhETN1B67qKISDTX+60mM+fLzJlzZjZc13VdFz5YHf+TDS96PB4bhjGdTn9vAsAGALTbbZZlA4HA8/Pzf8v1ej2RSASDwcvLy9+brusujj2fz/f392OxmCiKkiRhjAVBwBjLsszzPMZYFEVRFDHGPM/Lsnx/fw/LnAGgWCySJFkqldLpdDgcLhaL8Xg8kUiUSiWapnme53k+Eolks9nt7W1d1xey52uaxjAMADw+PsqyDACNRkPTNAA4OjoajUbD4TCXywEAQujs7GyRs0ev1wuFQoVCQZIkhFC5XN7b2+M4rlwuI4S8FBBC+XyeJMlms7mQl9Xa2dnJ5/PHx8csyzabzUwmIwjC+fl5MpmsVCqVSiWVSqmqSlGUYRhfdp7NZizLGobR7/clSfKqoKoqAGCM+/3+YDDIZrOO40Sj0UXOq7dfKBQoiorH4wRBcBwXDodpmuY4jiAIhmEYhiFJMplM+v3+Vqu1Luu6HggETk5OdF2vVquKoiiKUq1WVVWt1+u1Wk3TtNPTU0VRJpPJutzpdILBoGmavV7v6ju63e7Nzc1nk6zKk8kklUpRFBWJRP58haZpmqZDodDu7q7XxesyALy/v1uWdXt7a9v26APbth8eHizLenl5sW17Pp97wZ+yV7DpdCoIAkLo6elpufT29nZ4eHhwcPD6+rq607o8Ho9Jktzc3Ly4uFhO3t3d+Xy+ra2t6+vr7+Ul3W7XNE3vbXuy4zimabZaLcdxfpTXvhH3g59i/gLwmMRO20VmwgAAAABJRU5ErkJggg==\"> "; 
        String foodMarket4 ="src=\"data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAABQAAAATCAIAAAAf7rriAAACbklEQVQ4jZWUS0/qQBSA/cWuDCEmkJZeKSYMlILWhYG+JkJ4JCwwRh59mCJpWBgXYPCV1Kg8KhETN1B67qKISDTX+60mM+fLzJlzZjZc13VdFz5YHf+TDS96PB4bhjGdTn9vAsAGALTbbZZlA4HA8/Pzf8v1ej2RSASDwcvLy9+brusujj2fz/f392OxmCiKkiRhjAVBwBjLsszzPMZYFEVRFDHGPM/Lsnx/fw/LnAGgWCySJFkqldLpdDgcLhaL8Xg8kUiUSiWapnme53k+Eolks9nt7W1d1xey52uaxjAMADw+PsqyDACNRkPTNAA4OjoajUbD4TCXywEAQujs7GyRs0ev1wuFQoVCQZIkhFC5XN7b2+M4rlwuI4S8FBBC+XyeJMlms7mQl9Xa2dnJ5/PHx8csyzabzUwmIwjC+fl5MpmsVCqVSiWVSqmqSlGUYRhfdp7NZizLGobR7/clSfKqoKoqAGCM+/3+YDDIZrOO40Sj0UXOq7dfKBQoiorH4wRBcBwXDodpmuY4jiAIhmEYhiFJMplM+v3+Vqu1Luu6HggETk5OdF2vVquKoiiKUq1WVVWt1+u1Wk3TtNPTU0VRJpPJutzpdILBoGmavV7v6ju63e7Nzc1nk6zKk8kklUpRFBWJRP58haZpmqZDodDu7q7XxesyALy/v1uWdXt7a9v26APbth8eHizLenl5sW17Pp97wZ+yV7DpdCoIAkLo6elpufT29nZ4eHhwcPD6+rq607o8Ho9Jktzc3Ly4uFhO3t3d+Xy+ra2t6+vr7+Ul3W7XNE3vbXuy4zimabZaLcdxfpTXvhH3g59i/gLwmMRO20VmwgAAAABJRU5ErkJggg==\"> style=\"line-height:20.8px\">\n"; 

        List<Gas> gasesList=new ArrayList<Gas>();
        for (int j = 1; j < rows.size(); j++) {
            Element row=rows.get(j);
            Elements cols = row.select("td");
            Gas gasOne=new Gas();
            String[] parametrai=new String[6];
            parametrai[0]=cols.get(0).text();
            parametrai[1]=cols.get(1).text();
            parametrai[2]=cols.get(2).text();
            parametrai[3]=cols.get(3).text();
            parametrai[4]=cols.get(4).text();
            parametrai[5]=row.select("[src]").toString();
            String spliting="<img alt=\"\" ";
            String[] parts=parametrai[5].split(spliting);
            if(parts.length==0){
                parts[0]=parametrai[5];
            }
            String foodBool="false";
            String airBool="false";
            String showerBool="false";
            for (String choose : parts) {
                if(choose.length()==food.length() || choose.length()==food1.length() || choose.length()==food2.length() || 
                        choose.length()==food3.length() || choose.length()==food4.length()||
                        choose.length()==foodMarket.length() || choose.length()==foodMarket1.length() ||
                        choose.length()==foodMarket2.length()||choose.length()==foodMarket3.length() ||
                        choose.length()==foodMarket4.length()){
                    foodBool="true";
                }
                else if(choose.length()==shower.length() || choose.length()==shower1.length() || 
                        choose.length()==shower2.length() || choose.length()==shower3.length() || 
                        choose.length()==shower4.length()){
                    showerBool="true";
                }
                else if(choose.length()==airBool.length()){
                    airBool="true";
                }
            }
            String[] options=new String[3];
            options[0]=foodBool;
            options[1]=airBool;
            options[2]=showerBool;
            gasOne=new Gas(parametrai[0],parametrai[1],parametrai[2],parametrai[3],parametrai[4],options);
            gasesList.add(gasOne);
        }
        for (int j = 0; j < gasesList.size(); j++) {
            System.out.println(gasesList.get(j).adresas+", "+gasesList.get(j).miestas+";"+"Neste;"+gasesList.get(j).papild[0]+";"
                +gasesList.get(j).papild[1]+";"+gasesList.get(j).papild[2]);
        }
    }
    
    public static void orlenGas() throws IOException{
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
            
            for (int i = 0; i < parts.length; i++) {
                if(parts[i].startsWith(" +")){
                    try{
                        parts[i]=parts[i].substring(18);
                        if(parts[i].charAt(parts[i].length()-1)==' ' || parts[i].charAt(parts[i].length()-1)==',')
                            parts[i]=parts[i].substring(0,parts[i].length()-1);
                        System.out.println(parts[i]+";"+"Orlen;true;true;true");
                    }
                    catch (Exception e){
                        
                    }
                }
                else{
                    if(parts[i].charAt(parts[i].length()-1)==' ' || parts[i].charAt(parts[i].length()-1)==',')
                            parts[i]=parts[i].substring(0,parts[i].length()-1);
                    System.out.println(parts[i]+";"+"Orlen;true;true;true");
                }
            }
        }
    }
    
    public static void lukoilGas() throws IOException{
        String url="http://www.lukoil.lt/degalines/informacija_apie_degalines";
        Document document = Jsoup.connect(url).get();
        Element table = document.select("table.degalines").get(0);
        Elements rows = table.select("tr");
        for (int j = 2; j < rows.size()-1; j++) { 
            Element row=rows.get(j);
            Elements cols = row.select("td");
            String adresas;
            adresas =cols.get(0).text().charAt(cols.get(0).text().length()-1)=='*'
                    ?cols.get(0).text().substring(0,cols.get(0).text().length()-2)
                    :cols.get(0).text();
            String foodBool;
            String airBool;
            String showerBool;
            foodBool=cols.get(13).text().isEmpty()?"false":"true";
            showerBool=cols.get(15).text().isEmpty()?"false":"true";
            airBool=cols.get(19).select("[src]").toString().isEmpty()?"false":"true";
            System.out.println(adresas+";"+"Lukoil;"+foodBool+";"+airBool+";"+showerBool);
        }
    }
    
    public static void bpGas() throws IOException{
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
            String options = cols.select("[src]").toString();
            String foodBool = "false";
            String airBool = "false";
            String showerBool = "false";
            String[] optionSplit = options.split("<img src=");
            for (String part : optionSplit){
                if (part.contains(food))
                    foodBool = "true";
                if (part.contains(air))
                    airBool = "true";
                if (part.contains(carwash))
                    showerBool = "true";
            }
            System.out.println(adresas+", "+city+";"+"Baltic Petroleum;"+foodBool+";"+airBool+";"+showerBool);
        }
    }
    
    public static void jozitaGas() throws IOException{
        String url="http://jozita.lt/kontaktai";
        Document document = Jsoup.connect(url).get();
        Element table = document.select(".content").get(1);
        Elements rows = table.select("p");
        for (int i = 2; i < rows.size(); i++){
            String tekstas = rows.get(i).text();
            String[] parts = tekstas.split(":");
            String adresas;
            String foodBool = "false";
            String showerBool = "false";
            if (parts[0].contains("Degalinė")){
                if (parts[1].indexOf("Tel") != -1)
                    adresas = parts[1].substring(0, parts[1].indexOf("Tel")).trim();
                else
                    adresas = parts[1].substring(0, parts[1].indexOf("Vadovo")).trim();
                if (parts[0].contains("arduotuvė"))
                    foodBool = "true";
                if (parts[0].contains("lovykla"))
                    showerBool = "true";
                System.out.println(adresas+";"+"Jozita;"+foodBool+";false;"+showerBool);
            }
        }
    }
    
    public static void luktarnaGas() throws IOException{
        String url="http://www.luktarna.lt/degalines";
        Document document = Jsoup.connect(url).get();
        String luktarnaLogo="images/graphics/1181315803.gif";
        String food = "images/ikon_maistas.gif";
        String air = "images/ikon_vanduo_oras.gif";
        String carwash = "images/plovykla.gif";
        Element table = document.select(".collapse").get(0);
        Elements rows = table.select("tr");
        for (int i = 1; i < rows.size(); i++){
            Element row = rows.get(i);
            Elements cols = row.select("td");
            String tinklas = cols.get(1).toString();
            String foodBool = "false";
            String airBool = "false";
            String showerBool = "false";
            String adresas;
            if (tinklas.contains(luktarnaLogo)){
                adresas = cols.get(0).text();
                String options = cols.select("[src]").toString();
                String[] optionSplit = options.split("alt=");
                 for (String part : optionSplit){
                    if (part.contains(food))
                        foodBool = "true";
                    if (part.contains(air))
                        airBool = "true";
                    if (part.contains(carwash))
                        showerBool = "true";
                }
                System.out.println(adresas+";"+"Luktarna;"+foodBool+";"+airBool+";"+showerBool);
            }
        }
    }
}
