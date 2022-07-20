package com.ssafy.oop3_3.inner;

public class AnonymousInner {
    public Folder gotNewFolder() {
        return new Folder() {
            public void open() { /* */ }

            public void fold() { /* */ }
        };
//      같은 방법
//    	class TempClass implements Folder {
//          public void open() { /* */ }
//
//          public void fold() { /* */ }
//    	}
//    	return new TempClass();
    }
}

interface Folder {
    public void open();

    public void fold();
}