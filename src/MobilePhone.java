import java.util.ArrayList;

public class MobilePhone extends Product{

    private static int phoneId = 1;
    private int battery;
    private String color;
    private int camResolution;
    private static ArrayList<MobilePhone> mobilePhones = new ArrayList<>();

    public MobilePhone(){

    }

    //phoneId varsayılan olarak 1 atıyorum her yeni nesnede 1 artıyor ve markanın sistemde kayıtlı benzersiz numarası olusuyor.
    public MobilePhone(String name, double price, int discountRate, int stock,
                       Brand brand, double screenSize, int ram, int memory, int battery, String color, int camResolution) {
        super(phoneId, name, price, discountRate, stock, brand, screenSize, ram, memory);

        phoneId++;
        this.battery = battery;
        this.color = color;
        this.camResolution=camResolution;
    }

    public void menu(){

        System.out.println("\n" +
                " 1- Telefonları Listele\n" +
                " 2- Yeni Telefon Ekle\n" +
                " 3- Telefon Sil\n" +
                " 4- Telefonları ID numarasına göre Sırala\n" +
                " 5- Telefonları Markaya göre filtrele");
        System.out.print("Lütfen Yapmak İstediğiniz İşlemi Seçiniz : ");
        int select = input.nextInt();

        if(select == 1 || select == 4) getProducts();
        if(select == 2) addItem();
        if(select == 3) deleteItem();
        if(select == 5) brandFilter();
    }

    public void addItem(){
        System.out.print("Ürünün Fiyatı : ");
        double price = input.nextDouble();
        System.out.print("Ürünün Modeli : ");
        input.nextLine();
        String name = input.nextLine();
        System.out.print("İndirim Oranı : ");
        int discountRate = input.nextInt();
        System.out.print("Stok Adedi : ");
        int stock = input.nextInt();
        System.out.print("RAM Boyutu : ");
        int ram = input.nextInt();
        System.out.print("Ekran Boyutu : ");
        double screenSize = input.nextDouble();
        System.out.print("Ürünün Hafızası : ");
        int memory = input.nextInt();
        System.out.print("Batarya Kapasitesi : ");
        int battery = input.nextInt();
        input.nextLine();
        System.out.print("Ürünün Rengi : ");
        String color = input.nextLine();
        System.out.print("Kamera çözünürlüğü : ");
        int camResolution= input.nextInt();
        Brand.printBrands();
        System.out.print("Telefonun Markasını Seçiniz : ");
        Brand brand = Brand.getBrand(input.nextInt());

        MobilePhone phoneObject = new MobilePhone(name,price,discountRate,stock,brand,screenSize,ram,memory,battery,color,camResolution);
        mobilePhones.add(phoneObject);
        System.out.println("Eklenen Telefonun Id : " + phoneObject.getId());
    }

    @Override
    public void getProducts() {
        print(mobilePhones);
    }

    public void print(ArrayList<MobilePhone> phoneList){
        if(phoneList == null){
            phoneList = this.mobilePhones;
        }
        System.out.println("\nCep Telefonu Listesi");
        System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("| ID | Ürün Adı                  | Fiyatı          | Marka           | Stok Adedi   | İndirim Oranı      | RAM    | Ekran Boyutu      | Hafızası   | Pil Kapasitesi  | Renk           | Kamera    |");
        System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");

        for(MobilePhone i : phoneList){
            System.out.printf("| %-2s | %-25s | %-15s | %-15s | %-12s | %-18s | %-6s | %-17s | %-10s | %-15s | %-14s | %-9s | \n",
                    i.getId(), i.getName(), i.getPrice()+" TL", i.getBrand().getName(), i.getStock(),"%"+i.getDiscountRate(), i.getRam()+" GB",
                    i.getScreenSize()+"''", i.getMemory()+" GB", i.getBattery()+"mAh", i.getColor(), i.getCamResolution()+" MP");
        }
    }

    public void deleteItem(){
        getProducts();
        System.out.print("Silmek İstediğiniz Telefonun Id'sini Giriniz : ");
        int id = input.nextInt();
        mobilePhones.remove(id-1);      //indisler 0 dan basladıgı için -1 yazıyorum.
        System.out.println("Güncel Telefon Listesi : ");
        getProducts();
    }

    public void brandFilter(){
        System.out.print("Filtrelemek İstediğiniz Telefon Markasını Giriniz : ");
        input.nextLine();
        String filter = input.nextLine();
        ArrayList<MobilePhone> filterMobilePhones = new ArrayList<>();
        for(MobilePhone i : mobilePhones){
            if(filter.equalsIgnoreCase(i.getBrand().getName())){
                filterMobilePhones.add(i);
            }
        }
        print(filterMobilePhones);
    }

    public static int getPhoneId() {
        return phoneId;
    }

    public int getBattery() {
        return battery;
    }

    public void setBattery(int battery) {
        this.battery = battery;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getCamResolution() {
        return camResolution;
    }

    public void setCamResolution(int camResolution) {
        this.camResolution = camResolution;
    }
}