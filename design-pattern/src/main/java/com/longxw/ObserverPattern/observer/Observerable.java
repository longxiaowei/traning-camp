package com.longxw.ObserverPattern.observer;

/**被观察者
 * @author longxw
 * @since 2019-9-10
 */
public interface Observerable {
    void registerObserver(Observer o);
    void removeObserver(Observer o);
    void notifyObserver();
}
