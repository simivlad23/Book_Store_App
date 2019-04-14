package service;

import model.Product;
import repository.ProdusRepository;

public interface ProductService {

    Product save(Product product);

    public void addproduct(Product product);
    public void removeProduct(Long idProd);

    public void subStok(Product product);
    public void addStok(Long idProd,int stok);


    public ProdusRepository getProductRepository();
}
