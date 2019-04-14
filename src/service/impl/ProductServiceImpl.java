package service.impl;

import model.Product;
import repository.ProdusRepository;
import service.ProductService;

public class ProductServiceImpl implements ProductService {


    public ProdusRepository produsRepository;

    public ProductServiceImpl(ProdusRepository produsRepository) {

        this.produsRepository = produsRepository;
    }

    @Override
    public Product save(Product product) {
        Product product1 = produsRepository.findByISBN(product.getISBN());
        if (product1!= null) {
            // the product already exist
            // then we make an update
            System.out.println(product1.getId());
            product1.setQuantity(product.getQuantity());
            return produsRepository.update(product1);
        } else {

            return produsRepository.create(product);
        }
    }

    @Override
    public void addproduct(Product product) {

        //TODO validation
        produsRepository.create(product);
    }

    @Override
    public void removeProduct(Long idProd) {

        produsRepository.deleteById(idProd);

    }

    @Override
    public void subStok(Product product) {

            produsRepository.update(product);

    }

    @Override
    public void addStok(Long idProd, int stok) {


        Product product = produsRepository.findById(idProd);


        int stoc = product.getQuantity() + stok;
        produsRepository.update(product);

    }

    @Override
    public ProdusRepository getProductRepository() {
        return produsRepository;
    }
}
