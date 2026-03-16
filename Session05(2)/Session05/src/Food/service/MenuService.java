package Food.service;
import Food.model.*;
import Food.exception.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
public class MenuService {
    private static List<MenuItem> menuList = new ArrayList<>();
    public void addItem(MenuItem item) throws DuplicateItemIdException{

        for(MenuItem m : menuList){
            if(m.getId().equals(item.getId())){
                throw new DuplicateItemIdException("ID da ton tai");
            }
        }
        menuList.add(item);
    }
    public List<MenuItem> getMenuList(){
        return menuList;
    }
    public List<MenuItem> searchByName(String keyword){
        return menuList.stream()
                .filter(item -> item.getName().toLowerCase().contains(keyword.toLowerCase()))
                .toList();
    }
    public List<MenuItem> searchByPrice(double min, double max){
        return menuList.stream()
                .filter(item -> item.getBasePrice() >= min && item.getBasePrice() <= max)
                .toList();
    }
    public void showMenu() {

        if (menuList.isEmpty()) {
            System.out.println("Menu is empty");
            return;
        }

        System.out.println("\n----- MENU LIST -----");

        menuList.stream().forEach(item ->
                System.out.println(
                        "ID: " + item.getId() +
                                " | Name: " + item.getName() +
                                " | Price: " + item.getBasePrice()
                )
        );
    }
    public void deleteItem(String id) throws ItemNotFoundException {
        MenuItem item = findById(id)
                .orElseThrow(() -> new ItemNotFoundException("Khong tim thay mon an"));

        menuList.remove(item);
    }
    public Optional<MenuItem> findByName(String name) {
        return menuList.stream()
                .filter(m -> m.getName().equalsIgnoreCase(name))
                .findFirst();
    }
    public Optional<MenuItem> findById(String id) {
        return menuList.stream()
                .filter(m -> m.getId().equalsIgnoreCase(id))
                .findFirst();
    }

}
