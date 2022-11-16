import java.util.Comparator;
import java.util.TreeSet;

public class Brand {
    private int id;
    private String name;

    //Brand türünde bir TreeSet brandList adında
    //compare metodu her nesneyi birbiriyle karsılastırıp sıralama yapacak!
    //String ifadelerin karsılastırılmasında compareTo(); metodunu kullanıyorum alfabetik sıralama !

    private static TreeSet<Brand> brandList = new TreeSet<>(new Comparator<Brand>() {
        @Override
        public int compare(Brand o1, Brand o2) {
            return o1.getName().compareTo(o2.getName());
        }
    });

    public Brand(int id, String name){
        this.id = id;
        this.name = name;
    }

    public int getId(){
        return this.id;
    }

    public String getName(){
        return this.name;
    }

    public void setName(String name){
        this.name = name;
    }

    public static void createBrands(){
        brandList.add(new Brand(1,"Samsung"));
        brandList.add(new Brand(2,"Lenovo"));
        brandList.add(new Brand(3,"Apple"));
        brandList.add(new Brand(4,"Huawei"));
        brandList.add(new Brand(5,"Casper"));
        brandList.add(new Brand(6,"Asus"));
        brandList.add(new Brand(7,"HP"));
        brandList.add(new Brand(8,"Xiaomi"));
        brandList.add(new Brand(9,"Monster"));
    }

    static {
        createBrands();
    }

    //Marka yazdır metotunda createBrands metodunu calıstırıyorum ve markaları olusturuyorum.
    public static void printBrands(){
        System.out.println("\nMarkalarımız\n=================");
        System.out.println("| ID | Marka    |");
        //Collections.sort(brandList2);
        for (Brand brand : brandList){
            System.out.printf("| %-2s | %-8s | \n" , brand.id, brand.getName());
        }
    }

    //id'sini girdiğim markayı döngüyle gezicem eger öyle bir id de marka varsa degeri döndürecek !
    public static Brand getBrand(int id){
        for(Brand i:brandList){
            if(id == i.getId()){
                return i;
            }
        }
        return null;
    }
}
