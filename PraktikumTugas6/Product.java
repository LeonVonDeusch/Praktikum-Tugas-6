/* 
:::::::::     :::    ::::    :::::::::::: :::   ::::::::::::::::::::::::::    :::::::::::: :::::::::::    :::    ::::::::: :::::::::::::::::::::  :::    ::::    ::::::::::::::::::::::: 
:+:    :+:  :+: :+:  :+:+:   :+::+:    :+::+:   :+:     :+:     :+:    :+:   :+: :+:    :+:    :+:      :+: :+:  :+:    :+:    :+:    :+:       :+: :+:  :+:+:   :+::+:    :+:   :+:     
+:+    +:+ +:+   +:+ :+:+:+  +:++:+    +:+ +:+ +:+     +:+      +:+    +:+  +:+  +:+    +:+    +:+     +:+   +:+ +:+    +:+    +:+    +:+      +:+   +:+ :+:+:+  +:++:+    +:+   +:+     
+#+    +:++#++:++#++:+#+ +:+ +#++#+    +:+  +#++:     +#+       +#+    +#++:++   +#++:++#:     +#+    +#++:++#++:+#++:++#:     +#+    :#::+::#+#++:++#++:+#+ +:+ +#++#+    +:+   +#+     
+#+    +#++#+     +#++#+  +#+#+#+#+    +#+   +#+     +#+        +#+    +#+  +#+  +#+    +#+    +#+    +#+     +#++#+    +#+    +#+    +#+     +#+     +#++#+  +#+#+#+#+    +#+   +#+     
#+#    #+##+#     #+##+#   #+#+##+#    #+#   #+#    #+#         #+#    #+#   #+# #+#    #+#    #+#    #+#     #+##+#    #+#    #+#    #+#     #+#     #+##+#   #+#+##+#    #+#   #+#     
######### ###     ######    #############    ###   #######################    ######    #################     ######    #################     ###     ######    ######################## 

 ::::::::  :::    ::::::::::  ::: :::::::::: ::::::: ::::::::::: ::::::: :::::::::::  :::    :::    :::  :::::::  :::::::: :::::::::: 
:+:    :+::+:     :+:    :+::+:+: :+:    :+::+:   :+::+:     :+::+:   :+::+:     :+::+:+:  :+:+:  :+:+: :+:   :+::+:    :+::+:    :+: 
      +:++:+ +:+  +:+         +:+ +:+       +:+  :+:+       +:+ +:+  :+:+       +:+   +:+    +:+    +:+ +:+  :+:+       +:++:+        
    +#+ +#+  +:+  +#++:++#+   +#+ +#++:++#+ +#+ + +:+      +#+  +#+ + +:+      +#+    +#+    +#+    +#+ +#+ + +:+    +#++: +#++:++#+  
  +#+  +#+#+#+#+#+       +#+  +#+        +#++#+#  +#+     +#+   +#+#  +#+     +#+     +#+    +#+    +#+ +#+#  +#+       +#+       +#+ 
 #+#         #+#  #+#    #+#  #+# #+#    #+##+#   #+#    #+#    #+#   #+#    #+#      #+#    #+#    #+# #+#   #+##+#    #+##+#    #+# 
##########   ###   ######## ###############  #######     ###     #######     ###    ############################  ########  ########  
*/

public class Product<T extends Comparable<T>> implements Comparable<Product<T>> {
    private int id; //id produksi barang
    private String name; //nama barang
    private T category; //kategori barang
    public double price; //harga barang

    // konstruktor default
    public Product() {
        this.id = 0;
        this.name = "";
        this.category = null;
        this.price = 0.0;
    }

    // konstruktor dengan parameter setter
    public Product(int id, String name, T category, double price) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.price = price;
    }

    // getter id
    public int getId() {
        return id;
    }

    // getter name
    public String getName() {
        return name;
    }

    // getter category
    public T getCategory() {
        return category;
    }

    // getter price
    public double getPrice() {
        return price;
    }

    // Mengimplementasikan metode compareTo untuk membandingkan 
    // produk berdasarkan kategori.
    // Kategori mengimplementasikan Comparable.
    @Override
    public int compareTo(Product<T> other) {
        return this.category.compareTo(other.getCategory());
    }

    // Mengembalikan representasi string dari objek Product, 
    // berisi id, nama, kategori, dan harga produk.
    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + 
                ", category=" + category.toString() +
                ", price=" + price +
                '}';
    }
} 