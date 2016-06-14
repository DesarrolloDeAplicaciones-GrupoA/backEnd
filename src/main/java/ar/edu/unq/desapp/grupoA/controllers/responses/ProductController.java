package ar.edu.unq.desapp.grupoA.controllers.responses;


import ar.edu.unq.desapp.grupoA.controllers.TravelCreationResponse;
import ar.edu.unq.desapp.grupoA.factories.ProductFactory;
import ar.edu.unq.desapp.grupoA.models.Product;
import ar.edu.unq.desapp.grupoA.models.Travel;
import ar.edu.unq.desapp.grupoA.models.UserModel;
import ar.edu.unq.desapp.grupoA.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.annotation.PostConstruct;
import javax.ws.rs.*;
import java.util.List;

@Path("products")
@Controller("productController")
public class ProductController {

    private ProductService productService;
    private ProductFactory productFactory;

    @GET
    @Path("all")
    @Produces("application/json")
    public List<Product> getAll() {
        return this.getProductService().findAll();
    }

/*    @POST
    @Path("create")
    @Consumes("application/json")
    @Produces("application/json")
    public ProductCreationResponse create(@QueryParam("token") String token, ProductCreationBody productBody) {
        UserModel user = this.getUserTokenRepository().findByUserToken(token);
        Product product = this.productService.createProduct(productBody.getName(),productBody.getStock(),productBody.getPointCost());
        return ProductCreationResponse.build(product);
    }
*/
     @POST
    @Path("create")
    @Consumes("application/json")
    @Produces("application/json")
    public Product create(Product productBody) {
      //  UserModel user = this.getUserTokenRepository().findByUserToken(token);
        Product product = this.productService.createProduct(productBody.getName(),productBody.getStock(),productBody.getPointCost());
        return (product);
    }

    @GET
    @Path("{id}")
    //@Consumes("application/json")
    @Produces("application/json")
    public Product findProductsByID( @PathParam("id") Integer id) {
        Product productFound = this.getProductFactory().getProductByID(id);
        return productFound;
    }

    @PostConstruct
    public void loadData() {
        this.getProductFactory().createBasicProducts();
    }

    @Autowired
    public void setProductService(ProductService productService) {
        this.productService = productService;
    }

    @Autowired
    public void setProductFactory(ProductFactory productFactory) {
        this.productFactory = productFactory;
    }

    public ProductFactory getProductFactory() {
        return productFactory;
    }

    public ProductService getProductService() {
        return productService;
    }

}
