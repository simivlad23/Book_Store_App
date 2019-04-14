package repository;

import model.Product;

import java.util.List;

public interface ProdusRepository {

    Product findByISBN(String isbn);

    Product findById(Long id);

    List<Product> findAll();

    //TODO operaratii de cautare cu filtre mai vedem cum facem

    boolean deleteById(Long id);

    Product update(Product product);

    Product create(Product product);
}
