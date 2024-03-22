public class PhoneColors {
    public static final String Red = "Красный";
    public static final String Yellow = "Желтый";
    public static final String SpaceGray = "Тёмно-серый";

    public static String getColorBeNumber(int number) {
        switch (number) {
            case 1:
                return Red;
            case 2:
                return Yellow;
            case 3:
                return SpaceGray;

        }
        return "None";
    }
}


