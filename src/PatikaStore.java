import java.util.Scanner;

public class PatikaStore {
    Scanner input = new Scanner(System.in);
    boolean store = true;

    public void run(){
        while(store){
            System.out.println("\nPatika Store Ürün Yönetim Paneli ! ");
            System.out.println("" +
                    " 1 - Notebook İşlemleri\n" +
                    " 2 - Cep Telefonu İşlemleri\n" +
                    " 3 - Marka Listele\n" +
                    " 4 - Çıkış Yap");
            System.out.print("Lütfen Yapmak İstediğiniz İşlemi Seçiniz : ");
            int select = input.nextInt();

            switch (select){
                case 1:
                    Notebook notebook = new Notebook();
                    notebook.menu();
                    break;
                case 2:
                    MobilePhone mobilePhone = new MobilePhone();
                    mobilePhone.menu();
                    break;
                case 3:
                    Brand.printBrands();
                    break;
                case 4:
                    System.out.println("Çıkış Yapılıyor...\nYine Bekleriz...");
                    store = false;
                    break;
                default:
                    System.out.println("Geçersiz Seçim Yaptınız!, Lütfen Tekrar Deneyiniz. ");
                    break;
            }
        }
    }
}
