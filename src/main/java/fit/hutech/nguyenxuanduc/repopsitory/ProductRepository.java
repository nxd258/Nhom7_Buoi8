package fit.hutech.nguyenxuanduc.repopsitory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fit.hutech.nguyenxuanduc.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
}