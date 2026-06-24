package org.example.solid.ISP;

interface Document2{
    void open();
   default void save(){}
    default void scan(){}
    default void validate(){}
    default void edit(){}
}

class BaseDocument2 implements Document2{

    @Override
    public void open() {
    }
    @Override
    public void save() {
    }
}

class AdvanceDocument2 implements Document2{

    @Override
    public void open() {
    }
    @Override
    public void save() {
    }
    @Override
    public void scan() {
    }
    @Override
    public void validate() {
    }
    @Override
    public void edit() {
    }
}

class VirtualDocument2 implements Document2{

    @Override
    public void open() {
    }
    @Override
    public void scan() {
    }
    @Override
    public void edit() {
    }
}

class HardDocument2 implements Document2{

    @Override
    public void open() {
    }
}
// All the classes/documents implements the Document interface & got all the methods but
// does all the subclasses/documents really need all the methods of interface ? ->  No

// BaseDocument -> only need => open , save
// AdvanceDocument -> only need => open , save , scan, validate, edit
// VirtualDocument -> only need => open , scan
// HardDocument -> only need => open

public class ISP_With_ISP_With_Java8 {

    public static void main(String... r){

    }
}
