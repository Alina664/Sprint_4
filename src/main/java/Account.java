public class Account {

    private final String name;

    public Account(String name) {
        this.name = name;
    }

    public boolean checkNameToEmboss() {
        boolean result = false;
        if (name.length() <= 19)
              if (name.length() >= 3)
                  if (name.indexOf(' ') == name.lastIndexOf(' '))
                      if (name.indexOf(' ') > 0)
                          if (name.indexOf(' ') + 1 != name.length())
                              {
                                  result = true;
                              }
        return result;
    }

}