/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.app.coffee.product;

import com.app.coffee.category.Category;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.Component;
import java.util.ArrayList;
import java.sql.Statement;

public class ProductDao {

    private Component parentComponent;
    private ProductForm productForm;

    // add product
    public void insertProd() {
    }

    public boolean hasProductsForCategory(String category_id) {
        String sql = "SELECT COUNT(*) AS count FROM product WHERE category_id = ?";
        try ( Connection con = DatabaseConnection.getJDBConnection();  PreparedStatement pstmt = con.prepareStatement(sql)) {
            pstmt.setString(1, category_id);
            try ( ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    int count = rs.getInt("count");
                    return count > 0;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public ArrayList<Product> fillAllProduct() {
        ArrayList<Product> listProduct = new ArrayList<>();
        String sql = """
                     select  p.image,c.category_name, p.product_name,p.description,pd.`size`,pd.price,p.product_id from product p join category c on p.category_id = c.category_id
                     left join product_detail pd on pd.product_id = p.product_id  where pd.size like 'S' AND p.status = 1
                     ORDER BY  p.created_at DESC
                     
                     """;
        try ( Connection con = DatabaseConnection.getJDBConnection();  PreparedStatement pstmt = con.prepareStatement(sql)) {

            try ( ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    String image = rs.getString(1);
                    String category = rs.getString(2);
                    String productName = rs.getString(3);
                    String description = rs.getString(4);
                    String size = rs.getString(5);
                    float price = rs.getFloat(6);
                    int idProduct = rs.getInt(7);
                    ProductDetail productDetail = new ProductDetail();
                    productDetail.setPrice(price);
                    productDetail.setSize(size);
                    Category c = new Category();
                    c.setCategory_name(category);
                    Product product = new Product(idProduct, c, productName, image, description, productDetail);
                    listProduct.add(product);

                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listProduct;
    }
    // kiem tra product
    public boolean isProductExists(String productName) {
        String sql = "SELECT COUNT(*) FROM product WHERE product_name = ? AND status = 1";
        try (Connection con = DatabaseConnection.getJDBConnection(); PreparedStatement pstmt = con.prepareStatement(sql)) {
            pstmt.setString(1, productName);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    int count = rs.getInt(1);
                    return count > 0; // Trả về true nếu product_name đã tồn tại với status = 1
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    // kiem tra khi edit product
    public boolean isProductUpdateExists(String productName, int productId) {
        String sql = "SELECT COUNT(*) FROM Product WHERE product_name = ? AND product_id != ? AND status = 1";
        try (Connection con = DatabaseConnection.getJDBConnection();
                PreparedStatement pstmt = con.prepareStatement(sql)) {
            pstmt.setString(1, productName);
            pstmt.setInt(2, productId);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return rs.getInt(1) > 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public Integer insertProduct(Product p) {
        Integer productId = null;
        String sql = "INSERT INTO `product` ( `category_id`, `product_name`, `image`, `description`, \n"
                + "                `status`, `created_at`, `updated_at`)VALUES( ?,?,? , ?, 1, NOW(),NOW() )";
        try ( Connection con = DatabaseConnection.getJDBConnection();  PreparedStatement pstmt = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            pstmt.setObject(1, p.getCategory().getCategory_id());
            pstmt.setObject(2, p.getProduct_name());
            pstmt.setObject(3, p.getImage());
            pstmt.setObject(4, p.getDescription());

            int rowsInserted = pstmt.executeUpdate();

            if (rowsInserted > 0) {
                ResultSet generatedKeys = pstmt.getGeneratedKeys();
                if (generatedKeys.next()) {
                    productId = generatedKeys.getInt(1); // Lấy product_id từ generatedKeys
                } else {
                    throw new SQLException("Failed to retrieve generated product_id.");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return productId;
    }
//ProductDetail
    public Product fillAllAddProductDetail(int idProduct) {
        Product p = new Product();
        String sql = """
                     select * from  product p 
                                     where p.product_id =? AND p.status =1
                      """;
        try ( Connection con = DatabaseConnection.getJDBConnection();  PreparedStatement pstmt = con.prepareStatement(sql)) {
            pstmt.setObject(1, idProduct);
            try ( ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    int id = rs.getInt(1);
                    int id_category = rs.getInt(2);
                    String productName = rs.getString(3);
                    String iamge = rs.getString(4);
                    String description = rs.getString(5);
                    Category c = new Category();
                    c.setCategory_id(id_category);

                    p = new Product(idProduct, c, productName, iamge, description);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return p;
    }

    public ArrayList<ProductDetail> fillAllProductDetailByID(int idProduct) {
        ArrayList<ProductDetail> listProductDt = new ArrayList<>();
        String sql = """
                     select pd.`size`,pd.price from product_detail pd join product p on pd.product_id =p.product_id 
                                     where p.product_id =? and pd.status = 1 and p.status =1
                     """;
        try ( Connection con = DatabaseConnection.getJDBConnection();  PreparedStatement pstmt = con.prepareStatement(sql)) {

            pstmt.setObject(1, idProduct);
            pstmt.executeQuery();
            try ( ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    String size = rs.getString(1);
                    float price = rs.getFloat(2);
                    ProductDetail pd = new ProductDetail(size, price);
                    listProductDt.add(pd);

                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listProductDt;
    }
    
    public ArrayList<ProductDetail> showDataProductDetail(int idProduct) {
        ArrayList<ProductDetail> listProductDt = new ArrayList<>();
        String sql = """
                       select pd.`size`,pd.price , p.product_name,p.description,p.image,c.category_name,c.category_id
                       from product_detail pd join product p on pd.product_id =p.product_id 
                       join category c on p.category_id = c.category_id  where p.product_id =? and pd.status = 1 and p.status =1
                     """;
        try ( Connection con = DatabaseConnection.getJDBConnection();  PreparedStatement pstmt = con.prepareStatement(sql)) {

            pstmt.setObject(1, idProduct);
            pstmt.executeQuery();
            try ( ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    String size = rs.getString(1);
                    float price = rs.getFloat(2);
                    String proName = rs.getString(3);
                    String description = rs.getString(4);
                    String iamge = rs.getString(5);
                    String categoryName = rs.getString(6);
                    int categoryID = rs.getInt(7);
                    Category c = new Category();
                    c.setCategory_id(categoryID);
                    Product p = new Product();
                    p.setProduct_id(idProduct);
                    p.setCategory(c);
                    p.setImage(iamge);
                    p.setProduct_name(proName);
                    p.setDescription(description);
                    ProductDetail pro_detail = new ProductDetail(p, size, price);
                    listProductDt.add(pro_detail);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listProductDt;
    }

    public Integer insertProductDetail(ProductDetail pDetail) {
        Integer row = null;
        String sql = """
                     INSERT INTO product_detail ( product_id, size, price, status, created_at, updated_at) VALUES
                     ( ?, ?, ?, 1, NOW(), NOW())  
                     """;
        try ( Connection con = DatabaseConnection.getJDBConnection();  PreparedStatement pstmt = con.prepareStatement(sql)) {
            pstmt.setObject(1, pDetail.getProduct().getProduct_id());
            pstmt.setObject(2, pDetail.getSize());
            pstmt.setObject(3, pDetail.getPrice());
            row = pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return row;
    }

    public static void main(String[] args) {
        ProductDao pd = new ProductDao();
        System.out.println(pd.fillAllProduct());
    }

    public Integer UpdateProductAndDetailSizeS(ProductDetail pd, int idProduct) {
        Integer row = null;
        String sql = """
                     update product p join category c on p.category_id = c.category_id join product_detail pd on pd.product_id = p.product_id
                     set p.image = ? , p.product_name = ?, p.category_id =?, p.description = ?, p.updated_at = NOW(),pd.updated_at = NOW(),
                     	pd.price = ? WHERE pd.product_id = ? AND pd.size like "S"
                     """;
        try ( Connection con = DatabaseConnection.getJDBConnection();  PreparedStatement pstmt = con.prepareStatement(sql)) {
            pstmt.setObject(1, pd.getProduct().getImage());
            pstmt.setObject(2, pd.getProduct().getProduct_name());
            pstmt.setObject(3, pd.getProduct().getCategory().getCategory_id());
            pstmt.setObject(4, pd.getProduct().getDescription());
            pstmt.setObject(5, pd.getPrice());
            pstmt.setObject(6, idProduct);
            row = pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return row;
    }

    public Integer UpdateProductAndDetailSizeL(ProductDetail pd, int idProduct) {
        Integer row = null;
        String sql = """
                     update product p join category c on p.category_id = c.category_id join product_detail pd on pd.product_id = p.product_id
                     set p.image = ? , p.product_name = ?, p.category_id =?, p.description = ?, p.updated_at = NOW(),pd.updated_at = NOW(),
                     	pd.price = ? WHERE pd.product_id = ? AND pd.size like "L"
                     """;
        try ( Connection con = DatabaseConnection.getJDBConnection();  PreparedStatement pstmt = con.prepareStatement(sql)) {
            pstmt.setObject(1, pd.getProduct().getImage());
            pstmt.setObject(2, pd.getProduct().getProduct_name());
            pstmt.setObject(3, pd.getProduct().getCategory().getCategory_id());
            pstmt.setObject(4, pd.getProduct().getDescription());
            pstmt.setObject(5, pd.getPrice());
            pstmt.setObject(6, idProduct);
            row = pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return row;
    }

    public ArrayList<ProductDetail> fillAllPriceS() {
        ArrayList<ProductDetail> listProductD = new ArrayList<>();
        String sql = """
                     select price from product_detail where size LIKE "S" ORDER BY  created_at DESC
                     
                     """;
        try ( Connection con = DatabaseConnection.getJDBConnection();  PreparedStatement pstmt = con.prepareStatement(sql)) {

            try ( ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    float price = rs.getFloat(1);
                    ProductDetail pd = new ProductDetail();
                    pd.setPrice(price);
                    listProductD.add(pd);

                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listProductD;
    }
    public ArrayList<ProductDetail> fillAllPriceL() {
        ArrayList<ProductDetail> listProductD = new ArrayList<>();
        String sql = """
                     select price from product_detail where size LIKE "L" ORDER BY  created_at DESC
                     
                     """;
        try ( Connection con = DatabaseConnection.getJDBConnection();  PreparedStatement pstmt = con.prepareStatement(sql)) {

            try ( ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    float price = rs.getFloat(1);
                    ProductDetail pd = new ProductDetail();
                    pd.setPrice(price);
                    listProductD.add(pd);

                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listProductD;
    }
    
    //Xoa mem
    public Integer DeleteMem(int idProduct) {
        Integer row = null;
        String sql = """
                     update product p join product_detail pd on pd.product_id = p.product_id
                     set  pd.status = 2 , p.status =2, p.updated_at = NOW(),pd.updated_at = NOW()
                     WHERE pd.product_id = ?
                     """;
        try ( Connection con = DatabaseConnection.getJDBConnection();  PreparedStatement pstmt = con.prepareStatement(sql)) {
            pstmt.setObject(1, idProduct);
            row = pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return row;
    }

    public Product getProductStatus(int idProduct) {
        Product product = null;
        String sql = "SELECT * FROM product WHERE product_id = ?";  // This line likely has the issue
        try (Connection con = DatabaseConnection.getJDBConnection(); 
             PreparedStatement pstmt = con.prepareStatement(sql)) {
            pstmt.setInt(1, idProduct);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    // Assuming Product class has a constructor that takes ResultSet
                    product = new Product();
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return product;
    }
}
