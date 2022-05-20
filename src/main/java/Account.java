public class Account {

    private final String name;

    public Account(String name) {
        this.name = name;
    }

    public boolean checkNameToEmboss() {
        boolean result = false;
        if (name.length() <= 19)
              if (name.length() >= 3)
                  if (name.indexOf(' ') == name.lastIndexOf(' ')) //проверяем, что пробел только один
                      if (name.indexOf(' ') > 0) //и он есть и находится не в начале
                          if (name.indexOf(' ') + 1 != name.length()) //и не в конце
                              {
                                  result = true;
                              }
        return result;
    }

}