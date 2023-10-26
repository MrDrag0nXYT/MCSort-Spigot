package zxc.mrdrag0nxyt.enums;

public enum SortType {
    SELECTION ("selection"),
    HEAP ("heap"),
    SHELL ("shell"),
    SIMPLE ("simple");


    private String title;

    SortType(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public String toString() {
        return "SortType{" +
                "title='" + title + '\'' +
                '}';
    }
}
