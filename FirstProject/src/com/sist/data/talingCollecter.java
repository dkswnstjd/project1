package com.sist.data;
import java.io.FileWriter;
import java.util.*; // ArrayList

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class talingCollecter {

   public void tallingAllData() {
      try{
         ArrayList<talingVO> list = new ArrayList<talingVO>();
         String[] site = {
            "https://taling.me/Home/Search/?cateMain=0",
            "https://taling.me/Home/Search/?cateMain=1",
            "https://taling.me/Home/Search/?cateMain=2",
            "https://taling.me/Home/Search/?cateMain=3",
            "https://taling.me/Home/Search/?cateMain=4"
         };
         int mno=1;
         int cno=5;
            Document doc = Jsoup.connect("https://taling.me/Home/Search/?cateMain=4").get();
            Elements link = doc.select("div.cont2_class a");
            for(int j=0; j<link.size(); j++) {
               try {
		                  String url ="https://taling.me"+link.get(j).attr("href");
		                  Document doc2 = Jsoup.connect(url).get();
	                      Element title = doc2.selectFirst("div.class_title div.title");
	                      System.out.println("제목:"+title.text());     
						  Element image = doc2.selectFirst("div.tutor_img a");
						  System.out.println("이미지:"+image.attr("href"));
	                      Element price = doc2.selectFirst("li.ohu"); //selectFirst가 0번째
	                      System.out.println("가격:"+price.text());
						  Element spot = doc2.selectFirst("div.region_name");  
						  System.out.println("지역:"+spot.text());
						  Element name =doc2.selectFirst("div.name");
						  System.out.println("이름:"+name.text());
						  Element time =doc2.selectFirst("li.hu");
						  System.out.println("시간:"+time.text());
						  Element info =doc2.selectFirst("div.d_info04");
						  System.out.println("수업소개:"+info.text());
						
						
                       String msg = mno+"|"+cno+"|"+title.text()+"|"+
						 image.attr("href")+  "|" + price
								.text()  +"|"+spot.text() 
                                +"|"+name.text()+"|"+time.text()+"|"+info.text()+"\r\n";
                       // 파일에 저장
						
						  FileWriter fw = new FileWriter("c:\\javaDev\\taling_data2.txt",true);
						  //append일때 true 
						  fw.write(msg); 
						  fw.close();
						 
                       mno++;
                       
                      
               }catch(Exception ex) {}
            }
      //   }
      }catch(Exception ex) {
         System.out.println(ex.getMessage()); // 에러 메세지 출력
      }
      //finally => 파일 닫기, 오라클 서버 연결 해제, 네트워크 서버
   }
   


   public static void main(String[] args) {
      
        talingCollecter m = new talingCollecter(); 
        m.tallingAllData();
       

   }
}