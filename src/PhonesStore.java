import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

public class PhonesStore {

    private ArrayList<Phone> phones;
    private final String dbPhonesFileName = "phones.txt";

    public PhonesStore() {
        phones = new ArrayList<>();

    }
    public int getPhonesCount() {
        return phones.size();
    }

    public  void addPhone(Phone phone) {
        phones.add(phone);
    }

    public Phone getPhoneByNumber(int number) throws Exception {
        int index = number - 1;

        if (index < 0 || index > phones.size() - 1) {
            throw new Exception("Ошибка. Телефона с таким номером не существует");

        }
        return phones.get(index);
    }


    public Phone deletePhoneByNumber(int number) throws Exception {
        int index = number - 1;

        if (index < 0 || index > phones.size() - 1) {
            throw new Exception("Ошибка. Телефона с таким номером не существует");

        }

        return phones.remove(index);
    }


    public String getPhonesInTableView() {
        String output = "";
        output = String.format("%3s%20s%15s%15s%17s\n", "№", "Модель", "Цвет", "Цена(руб.)", "Кол-во на складе");

        if (phones.size() > 0) {
            for (int i = 0; i < phones.size(); i++) {
                Phone currentPhone = phones.get(i);

                output += String.format("%3d%20s%15s%15d%17d\n", i + 1, currentPhone.getModel(), currentPhone.getColor(),
                        currentPhone.getPrice(), currentPhone.getBalance());
            }
        } else {
            output += "Список пуст\n";
        }

        return output;
    }

    public void savePhonesToFile() throws Exception {
        FileWriter fileWriter = new FileWriter(dbPhonesFileName);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

        bufferedWriter.write(Integer.toString(phones.size()));
        bufferedWriter.newLine();

        for (int i = 0; i < phones.size(); i++) {
            Phone currentPhone = phones.get(i);

            bufferedWriter.write(currentPhone.getModel());
            bufferedWriter.newLine();

            bufferedWriter.write(currentPhone.getColor());
            bufferedWriter.newLine();

            bufferedWriter.write(Integer.toString(currentPhone.getPrice()));
            bufferedWriter.newLine();

            bufferedWriter.write(Integer.toString(currentPhone.getBalance()));
            bufferedWriter.newLine();
        }

        bufferedWriter.close();
        fileWriter.close();
    }

    public void loadPhonesFromFile() throws Exception {
        FileReader fileReader = new FileReader(dbPhonesFileName);
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        int size = Integer.parseInt(bufferedReader.readLine());
        phones.clear();

        for (int i = 0; i < size; i++) {
            String model = bufferedReader.readLine();
            String color = bufferedReader.readLine();
            int price = Integer.parseInt(bufferedReader.readLine());
            int balance = Integer.parseInt(bufferedReader.readLine());

            phones.add(new Phone(model, color, price, balance));
        }

        bufferedReader.close();
        fileReader.close();
    }

}
