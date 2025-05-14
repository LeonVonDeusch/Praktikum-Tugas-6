import java.util.*;

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

// Kelas untuk mengelola produk
public class ProductManager {
    // List untuk menyimpan semua produk
    private List<Product<?>> products = new ArrayList<>();
    // Set untuk menyimpan kategori unik
    private Set<String> categories = new HashSet<>();
    // Queue untuk menyimpan produk yang sudah diproses
    private Queue<Product<?>> processedQueue = new LinkedList<>();

    // Menambahkan produk baru ke dalam list dan kategori
    public void addProduct(Product<?> product) {
        products.add(product);
        categories.add(product.getCategory().toString());
    }

    // Menghapus produk berdasarkan ID, mengembalikan true jika berhasil
    public boolean removeProductByID(int id) {
        for (Product<?> product : products) {
            if (product.getId() == id) {
                products.remove(product);
                return true;
            }
        }
        return false;
    }

    // Mencari produk (fungsi ini belum diimplementasikan)
    public List<Product<?>> searchProduct(){
        List<Product<?>> results = new ArrayList<>();
        return results;
    }

    // Mencari produk berdasarkan nama (tidak case sensitive)
    public List<Product<?>> searchProductByName(String name){
        List<Product<?>> results = new ArrayList<>();
        for (Product<?> product : products) {
            if (product.getName().equalsIgnoreCase(name)) {
                results.add(product);
            }
        }
        return results;
    }

    // Mencari produk berdasarkan kategori
    public List<Product<?>> searchProductByCategory(String category) {
        List<Product<?>> results = new ArrayList<>();
        for (Product<?> product : products) {
            if (product.getCategory().toString().equalsIgnoreCase(category)) {
                results.add(product);
            }
        }
        return results;
    }

    // Mencari produk berdasarkan nama atau kategori
    public List<Product<?>> searchProductByNameCategory(String name, String category){
        List<Product<?>> results = new ArrayList<>();
        for (Product<?> product : products) {
            if (product.getName().equalsIgnoreCase(name) || product.getCategory().toString().equalsIgnoreCase(category)) {
                results.add(product);
            }
        }
        return results;
    }

    // Menampilkan semua produk yang sudah diurutkan berdasarkan kategori
    public void displayAllProductsSorted() {
        Collections.sort(products, new Comparator<Product<?>>() {
            @Override
            public int compare(Product<?> product1, Product<?> product2) {
                return product1.getCategory().toString().compareTo(product2.getCategory().toString());
            }
        });
        for (Product<?> product : products) {
            System.out.println(product);
        }
    }

    // Menampilkan semua kategori unik
    public void displayUniqueCategories() {
        for (String category : categories) {
            System.out.println(category);
        }
    }

    // Menambahkan produk ke dalam queue yang sudah diproses
    public void addToProcessedQueue(Product<?> product) {
        processedQueue.add(product);
    }

    // Menampilkan semua produk yang ada di queue yang sudah diproses
    public void displayProccessedQueue() {
        for (Product<?> product : processedQueue) {
            System.out.println(product);
        }
    }

    // Memfilter produk berdasarkan rentang harga
    public List<Product<?>> filterByPrice(double minPrice, double maxprice) {
        List<Product<?>> filtered = new ArrayList<>();
        for (Product<?> product : products) {
            if (product.getPrice() >= minPrice && product.getPrice() <= maxprice) {
                filtered.add(product);
            }
        }
        System.out.println("\nFiltered products by price range (" + minPrice + " - " + maxprice + "):");
        for (Product<?> product : filtered) {
            System.out.println(product);
        }
        return filtered;
    }
}