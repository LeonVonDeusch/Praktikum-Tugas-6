
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

public class MarketPlace {
    public static void main(String[] args) {
        // Membuat instance ProductManager untuk mengelola produk
        ProductManager productManager = new ProductManager();

        // Membuat beberapa produk dengan tipe String untuk kategori
        Product<String> product1 = new Product<>(1, "Laptop", "Electronics", 999.99);
        Product<String> product2 = new Product<>(2, "Smartphone", "Electronics", 699.99);
        Product<String> product3 = new Product<>(3, "Shoes", "Footwear", 49.99);
        Product<String> product4 = new Product<>(4, "Socks", "Footwear", 9.99);
        Product<String> product5 = new Product<>(5, "T-shirt", "Clothing", 19.99);
        Product<String> product6 = new Product<>(6, "Jeans", "Clothing", 39.99);
        Product<String> product7 = new Product<>(7, "Headphones", "Electronics", 199.99);
        Product<String> product8 = new Product<>(8, "Smartwatch", "Electronics", 249.99);
        Product<String> product9 = new Product<>(9, "Tablet", "Electronics", 499.99);
        Product<String> product10 = new Product<>(10, "Jacket", "Clothing", 89.99);

        // Menambahkan produk ke dalam ProductManager
        productManager.addProduct(product1);
        productManager.addProduct(product2);
        productManager.addProduct(product3);
        productManager.addProduct(product4);
        productManager.addProduct(product5);
        productManager.addProduct(product6);
        productManager.addProduct(product7);
        productManager.addProduct(product8);
        productManager.addProduct(product9);
        productManager.addProduct(product10);

        // Menampilkan semua produk yang sudah diurutkan berdasarkan kategori
        System.out.println("All Products (Sorted by Category):");
        productManager.displayAllProductsSorted();

        // Menampilkan kategori unik dari semua produk
        System.out.println("\nUnique Categories:");
        productManager.displayUniqueCategories();

        // Mencari produk berdasarkan nama "Laptop"
        System.out.println("\nSearch Results for 'Laptop':");
        var results = productManager.searchProductByName("Laptop");
        results.forEach(System.out::println);

        // Mencari produk berdasarkan kategori "Electronics"
        System.out.println("\nSearch Results for 'Electronics':");
        results = productManager.searchProductByCategory("Electronics");
        results.forEach(System.out::println);

        // Menghapus produk dengan ID 2, lalu menampilkan produk yang tersisa
        System.out.println("\nRemoving Product with ID 2:");
        productManager.removeProductByID(2);
        productManager.displayAllProductsSorted();

        productManager.filterByPrice(0, 1000);

        // Menambahkan produk ke dalam antrian processed queue
        productManager.addToProcessedQueue(product3);
        productManager.addToProcessedQueue(product1);
        productManager.addToProcessedQueue(product2);

        // Menampilkan isi processed queue
        System.out.println("\nProcessed Queue:");
        productManager.displayProccessedQueue();
    }
}
