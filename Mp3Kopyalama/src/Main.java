
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;



public class Main {
    
    private static ArrayList<Integer> icerik=new ArrayList<Integer>();
    
    public static void dosyaOku(){
        
        try {
            FileInputStream in=new FileInputStream("mars.wav");
            
            int oku;
            
            while((oku=in.read()) != -1){
                
                icerik.add(oku);//okuduğum dosyayı içeriğe koymuş olduk
                
            }
            
            
            
        } catch (FileNotFoundException ex) {
            System.out.println("Dosya Bulunamadı");
        } catch (IOException ex) {
            System.out.println("Dosya okunurken hata çıktı");
        }
    }
    
    public static void kopyala(String dosya_ismi){
        
        try {
            FileOutputStream out=new FileOutputStream(dosya_ismi);
            
            for (int deger: icerik) {
                out.write(deger);
            }
            
        } catch (FileNotFoundException ex) {
            System.out.println("Dosyaya Yazarken hata oluştu");
        } catch (IOException ex) {
            System.out.println("Dosya bulunamadı...");
        }
        
        
    }
    
    public static void main(String[] args) {
        //mp3 dosyasını br yerden başka bir yer kopyalama
        
        dosyaOku();//işeriğe göre dosya oku yapacak
        long baslangic=System.currentTimeMillis();//Şuan ki zamanı milisaniye cinsinden değerini alacak
        kopyala("mars2.wav");//Biz bunu yaptığımızda direk olarak dosyamız kopyalanmış olacak
        kopyala("mars3.wav");
        kopyala("mars4.wav");
        kopyala("mars3.wav");
        
        long bitis=System.currentTimeMillis();
        //Tread kullandığımızda bu saniyeleri düşürmeye çalışacağız
        System.out.println("3 dosyanın kopyalanması şu kadar sürdü : "+(bitis-baslangic)/1000+" saniye sürdü");
        
    }
    
}
