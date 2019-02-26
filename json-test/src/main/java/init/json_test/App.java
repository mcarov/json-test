package init.json_test;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class App  {
    public static void main(String[] args) {
        System.out.println("Укажите путь к файлу затрат:");
        try(Scanner scan = new Scanner(System.in)) {
        	File expensesFile = new File(scan.nextLine());
        	if(expensesFile.exists()) {
        		FileReader reader = new FileReader(expensesFile);
        		Gson gson = new Gson();
        		Customer customer = gson.fromJson(reader, Customer.class);
        		Stat stat = Stat.calculate(customer);
        		gson = new GsonBuilder().setPrettyPrinting().create();
        		String data = gson.toJson(stat);
        		FileWriter writer = new FileWriter(new File(expensesFile.getParent()+"\\stats_new.json"));
    			writer.write(data);
    			writer.close();
        		System.out.println("Расчет суммы затрат выполнен");
            }
        	else
        		System.out.println("Файл не найден");
        }
        catch(IOException e) {
			e.printStackTrace();
		}
    }
}
