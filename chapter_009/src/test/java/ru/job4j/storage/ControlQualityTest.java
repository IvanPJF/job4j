package ru.job4j.storage;

import org.junit.Test;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class ControlQualityTest {

    @Test
    public void whenCreateControlQualityWithStoragesThenContainsTheseStorages() {
        List<IStorage> result = new ArrayList<>(Arrays.asList(
                new Warehouse(new ArrayList<>(), 0, 25),
                new Shop(new ArrayList<>(), 25, 75),
                new Trash(new ArrayList<>())
        ));
        ControlQuality controlQuality = new ControlQuality(result);
        List<IStorage> expected = controlQuality.getStorages();
        assertThat(result, is(expected));
    }

    @Test
    public void whenAddStorageThenControlQualityContainsItStorage() {
        ControlQuality controlQuality = new ControlQuality(new ArrayList<>());
        IStorage warehouse = new Warehouse(new ArrayList<>(), 0, 25);
        controlQuality.addStorage(warehouse);
        List<IStorage> expected = controlQuality.getStorages();
        List<IStorage> result = Collections.singletonList(warehouse);
        assertThat(result, is(expected));
    }

    @Test
    public void whenFoodSuitWarehouseThenGetWarehouse() {
        LocalDateTime currentDate = LocalDateTime.now();
        IStorage warehouse = new Warehouse(new ArrayList<>(), 0, 25);
        IStorage shop = new Shop(new ArrayList<>(), 25, 75);
        IStorage trash = new Trash(new ArrayList<>());
        ControlQuality controlQuality = new ControlQuality(Arrays.asList(warehouse, shop, trash));
        IFood milk = new Food("Milk", currentDate.minusDays(1), currentDate.plusDays(7), 10, new Discount(50));
        IStorage result = controlQuality.defineStorage(milk, currentDate);
        assertThat(result, is(warehouse));
    }

    @Test
    public void whenFoodSuitShopThenGetShop() {
        LocalDateTime currentDate = LocalDateTime.now();
        IStorage warehouse = new Warehouse(new ArrayList<>(), 0, 25);
        IStorage shop = new Shop(new ArrayList<>(), 25, 75);
        IStorage trash = new Trash(new ArrayList<>());
        ControlQuality controlQuality = new ControlQuality(Arrays.asList(warehouse, shop, trash));
        IFood milk = new Food("Milk", currentDate.minusDays(1), currentDate.plusDays(1), 10, new Discount(50));
        IStorage result = controlQuality.defineStorage(milk, currentDate);
        assertThat(result, is(shop));
    }

    @Test
    public void whenFoodOldAndSuitShopThenGetShopAndFoodPriceWithDiscount() {
        LocalDateTime currentDate = LocalDateTime.now();
        IStorage warehouse = new Warehouse(new ArrayList<>(), 0, 25);
        IStorage shop = new Shop(new ArrayList<>(), 25, 75);
        IStorage trash = new Trash(new ArrayList<>());
        ControlQuality controlQuality = new ControlQuality(Arrays.asList(warehouse, shop, trash));
        IFood milk = new Food("Milk", currentDate.minusDays(8), currentDate.plusDays(1), 10, new Discount(50));
        IFood milkWithDiscount = new Food("Milk", currentDate.minusDays(8), currentDate.plusDays(1), 5, new Discount(50, true));
        IStorage result = controlQuality.defineStorage(milk, currentDate);
        assertThat(result, is(shop));
        assertThat(milk, is(milkWithDiscount));
    }

    @Test
    public void whenPutNewFoodThenGetWarehouseAndAddFoodToWarehouse() {
        LocalDateTime currentDate = LocalDateTime.now();
        IStorage warehouse = new Warehouse(new ArrayList<>(), 0, 25);
        IStorage shop = new Shop(new ArrayList<>(), 25, 75);
        IStorage trash = new Trash(new ArrayList<>());
        ControlQuality controlQuality = new ControlQuality(Arrays.asList(warehouse, shop, trash));
        IFood milk = new Food("Milk", currentDate.minusDays(1), currentDate.plusDays(10), 10, new Discount(50));
        IStorage result = controlQuality.put(milk, currentDate);
        List<IFood> storageWarehouse = result.getStorage();
        List<IFood> expected = new ArrayList<>(Collections.singletonList(milk));
        assertThat(result, is(warehouse));
        assertThat(storageWarehouse, is(expected));
    }

    @Test
    public void whenPutNormalFoodThenGetShopAndAddFoodToShop() {
        LocalDateTime currentDate = LocalDateTime.now();
        IStorage warehouse = new Warehouse(new ArrayList<>(), 0, 25);
        IStorage shop = new Shop(new ArrayList<>(), 25, 75);
        IStorage trash = new Trash(new ArrayList<>());
        ControlQuality controlQuality = new ControlQuality(Arrays.asList(warehouse, shop, trash));
        IFood milk = new Food("Milk", currentDate.minusDays(1), currentDate.plusDays(1), 10, new Discount(50));
        IStorage result = controlQuality.put(milk, currentDate);
        List<IFood> storageShop = result.getStorage();
        List<IFood> expected = new ArrayList<>(Collections.singletonList(milk));
        assertThat(result, is(shop));
        assertThat(storageShop, is(expected));
    }

    @Test
    public void whenPutOldFoodThenGetShopAndAddFoodWithDiscountToShop() {
        LocalDateTime currentDate = LocalDateTime.now();
        IStorage warehouse = new Warehouse(new ArrayList<>(), 0, 25);
        IStorage shop = new Shop(new ArrayList<>(), 25, 75);
        IStorage trash = new Trash(new ArrayList<>());
        ControlQuality controlQuality = new ControlQuality(Arrays.asList(warehouse, shop, trash));
        IFood milk = new Food("Milk", currentDate.minusDays(8), currentDate.plusDays(1), 10, new Discount(50));
        IFood milkWithDiscount = new Food("Milk", currentDate.minusDays(8), currentDate.plusDays(1), 5, new Discount(50, true));
        IStorage result = controlQuality.put(milk, currentDate);
        List<IFood> storageShop = result.getStorage();
        List<IFood> expected = new ArrayList<>(Collections.singletonList(milkWithDiscount));
        assertThat(result, is(shop));
        assertThat(storageShop, is(expected));
    }

    @Test
    public void whenPutExpiredFoodThenGetTrashAndAddFoodToTrash() {
        LocalDateTime currentDate = LocalDateTime.now();
        IStorage warehouse = new Warehouse(new ArrayList<>(), 0, 25);
        IStorage shop = new Shop(new ArrayList<>(), 25, 75);
        IStorage trash = new Trash(new ArrayList<>());
        ControlQuality controlQuality = new ControlQuality(Arrays.asList(warehouse, shop, trash));
        IFood milk = new Food("Milk", currentDate.minusDays(10), currentDate.minusDays(1), 10, new Discount(50));
        IStorage result = controlQuality.put(milk, currentDate);
        List<IFood> storageTrash = result.getStorage();
        List<IFood> expected = new ArrayList<>(Collections.singletonList(milk));
        assertThat(result, is(trash));
        assertThat(storageTrash, is(expected));
    }

    @Test
    public void whenResortFoodThenWaterMovesFromWarehouseToShopAndMilkMovesFromWarehouseToTrash() {
        LocalDateTime currentDate = LocalDateTime.now();
        IStorage warehouse = new Warehouse(new ArrayList<>(), 0, 25);
        IStorage shop = new Shop(new ArrayList<>(), 25, 75);
        IStorage trash = new Trash(new ArrayList<>());
        IFood water = new Food("Water", currentDate.minusDays(5), currentDate.plusDays(5), 10, new Discount(50));
        IFood milk = new Food("Milk", currentDate.minusDays(5), currentDate.minusDays(1), 10, new Discount(50));
        warehouse.add(water);
        warehouse.add(milk);
        ControlQuality controlQuality = new ControlQuality(Arrays.asList(warehouse, shop, trash));
        controlQuality.resort(currentDate);
        List<IFood> resultWarehouse = warehouse.getStorage();
        List<IFood> resultShop = shop.getStorage();
        List<IFood> resultTrash = trash.getStorage();
        List<IFood> expectedWarehouse = new ArrayList<>();
        List<IFood> expectedShop = new ArrayList<>(Collections.singletonList(water));
        List<IFood> expectedTrash = new ArrayList<>(Collections.singletonList(milk));
        assertThat(resultWarehouse, is(expectedWarehouse));
        assertThat(resultShop, is(expectedShop));
        assertThat(resultTrash, is(expectedTrash));
    }
}