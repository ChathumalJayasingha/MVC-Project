/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Chathumal
 */
public class ItemController {
    public static ArrayList<Item> getAllItems() throws ClassNotFoundException, SQLException{
        ResultSet executeQuery = DBConnection.getInstace().getConnection().createStatement().executeQuery("select*from item");
        ArrayList<Item>itemList=new ArrayList();
        while(executeQuery.next()){
            Item item=new Item(executeQuery.getString(1),executeQuery.getString(2),executeQuery.getDouble(3),executeQuery.getInt(4));
            itemList.add(item);
        }
        return itemList;
    }
    public static Item searchItem(String code) throws ClassNotFoundException, SQLException{
        ResultSet executeQuery = DBConnection.getInstace().getConnection().createStatement().executeQuery("select* from item where code='"+code+"' ");
        while (executeQuery.next()) {            
            Item item=new Item(executeQuery.getString(1),executeQuery.getString(2),executeQuery.getDouble(3),executeQuery.getInt(4));
            return item;
        }return  null;
    }
    public static boolean updateItem(Item item) throws ClassNotFoundException, SQLException{
        return DBConnection.getInstace().getConnection().createStatement().executeUpdate("update item set description='"+item.getDescription()+"', unitPrice='"+item.getUnitPrice()+"', qtyOnHand='"+item.getQtyOnHand()+"' where code='"+item.getCode()+"' ")>0;
    }
    public static boolean addItem(Item item) throws ClassNotFoundException, SQLException{
        return DBConnection.getInstace().getConnection().createStatement().executeUpdate("insert into item values('"+item.getCode()+"','"+item.getDescription()+"', '"+item.getUnitPrice()+"', '"+item.getQtyOnHand()+"'  )")>0;
    }
    
    public static boolean  deleteItem(String code) throws ClassNotFoundException, SQLException{
        return DBConnection.getInstace().getConnection().createStatement().executeUpdate("delete from item where code='"+code+"'")>0;
    
    }
    
}
