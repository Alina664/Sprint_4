public class Account {

    private final String name;

    public Account(String name) {
        this.name = name;
    }

    public boolean checkNameToEmboss() {
        String nameIsNotnull = name!=null? name: "";
        boolean isLengthValid = nameIsNotnull.length() <= 19 && nameIsNotnull.length() >= 3;
        boolean isSpaceOne = nameIsNotnull.indexOf(' ') == nameIsNotnull.lastIndexOf(' ');
        boolean isEndSpacesNotExist = nameIsNotnull.indexOf(' ') > 0 && nameIsNotnull.indexOf(' ') + 1 != nameIsNotnull.length();
        return isLengthValid && isSpaceOne && isEndSpacesNotExist;
    }

}