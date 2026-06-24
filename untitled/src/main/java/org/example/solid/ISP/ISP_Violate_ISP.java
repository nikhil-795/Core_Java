package org.example.solid.ISP;

interface Document{
    void open();
    void save();
    void scan();
    void validate();
    void edit();
}

class BaseDocument implements Document{

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

class AdvanceDocument implements Document{

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

class VirtualDocument implements Document{

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

class HardDocument implements Document{

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
// All the classes/documents implements the Document interface & got all the methods but
// does all the subclasses/documents really need all the methods of interface ? ->  No

// BaseDocument -> only need => open , save
// AdvanceDocument -> only need => open , save , scan, validate
// VirtualDocument -> only need => open , scan
// HardDocument -> only need => open

public class ISP_Violate_ISP {

    public static void main(String... r){

    }
}
