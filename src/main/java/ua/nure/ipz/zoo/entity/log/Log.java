package ua.nure.ipz.zoo.entity.log;

public interface Log<T> {
    void log(T target);

    String getLog();
}
