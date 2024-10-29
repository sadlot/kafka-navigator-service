/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pl.tsa.soft.navigator.service.consumer;

/**
 *
 * @author potatolot
 */
public interface MessageConsumer<T> {

    void consume(T message);

}
