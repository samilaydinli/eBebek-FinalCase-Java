import java.util.ArrayList;

public class Notebook extends Product{

    private static int notebookId = 1;
    private static ArrayList<Notebook> notebooks = new ArrayList<>();

    //Varsılan olarak nesne eklemek istiyorsam.
    static {
        notebooks.add(new Notebook("Monster abra a5",17499,12,150,Brand.getBrand(9),15.6,16,1024));
        notebooks.add(new Notebook("Lenovo Ideapad 3",5880,10,200,Brand.getBrand(2),15.6,4,256));
        notebooks.add(new Notebook("MacBook Pro",27999,5,100,Brand.getBrand(3),13,16,1024));
    }

    public Notebook(){

    }

    public Notebook(String name, double price, int discountRate, int stock, Brand brand, double screenSize, int ram, int memory) {

        super(notebookId, name, price, discountRate, stock, brand, screenSize, ram, memory);
        notebookId++;
    }

    @Override
    public void menu() {

        System.out.println("\n" +
                " 1- Notebook Listesini Görüntüle\n" +
                " 2- Yeni Notebook Ekle\n" +
                " 3- Notebook Sil\n" +
                " 4- Notebookları ID numarasına göre Sırala\n" +
                " 5- Notebookları Markaya göre filtrele");
        System.out.print("Lütfen Yapmak İstediğiniz İşlemi Seçiniz : ");
        int select = input.nextInt();

        if(select == 1 || select == 4) getProducts();
        if(select == 2) addItem();
        if(select == 3) deleteItem();
        if(select == 5) brandFilter();
    }

    @Override
    public void addItem() {
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
        Brand.printBrands();
        System.out.print("Notebook Markasını Seçiniz : ");
        Brand brand = Brand.getBrand(input.nextInt());

        Notebook notebookObject = new Notebook(name,price,discountRate,stock,brand,screenSize,ram,memory);
        notebooks.add(notebookObject);
        System.out.println("Eklenen Notebook Id : " + notebookObject.getId());
    }

    @Override
    public void getProducts() {
        print(notebooks);
    }

    public void print(ArrayList<Notebook> notebookList){
        System.out.println("\nNotebook Listesi");
        System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("| ID | Ürün Adı                  | Fiyatı          | Markası         | Stok Adedi   | İndirim Oranı      | RAM    | Ekran Boyutu      | Hafızası   |");
        System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------");

        for (Notebook i : notebookList){
            System.out.printf("| %-2s | %-25s | %-15s | %-15s | %-12s | %-18s | %-6s | %-17s | %-10s | \n",
                    i.getId(),i.getName(),i.getPrice()+" TL",i.getBrand().getName(),i.getStock(),
                    "% "+i.getDiscountRate(),i.getRam()+" GB",i.getScreenSize()+"''",i.getMemory()+" GB");
        }
    }

    @Override
    public void deleteItem() {
        getProducts();
        System.out.print("Silmek İstediğiniz Notebook Id'sini Giriniz : ");
        int id = input.nextInt();
        notebooks.remove(id - 1);
        System.out.println("Güncel Notebook Listesi ");
        getProducts();
    }

    public void brandFilter() {
        System.out.print("Filtrelemek İstediğiniz Notebook Markasını Giriniz : ");
        input.nextLine();
        String filter = input.nextLine();
        ArrayList<Notebook> filterNotebooks = new ArrayList<>();
        for(Notebook i : notebooks){
            if(filter.equalsIgnoreCase(i.getBrand().getName())){
                filterNotebooks.add(i);
            }
        }
        print(filterNotebooks);
    }

    public static int getNotebookId(){
        return notebookId;
    }
}