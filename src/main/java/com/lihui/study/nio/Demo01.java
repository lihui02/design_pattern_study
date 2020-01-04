package com.lihui.study.nio;

import java.io.IOException;
import java.nio.channels.SelectableChannel;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.spi.SelectorProvider;
import java.util.Set;

public class Demo01 {
    public static void main(String[] args) {
        Selector selector=new Selector() {
            @Override
            public boolean isOpen() {
                return false;
            }

            @Override
            public SelectorProvider provider() {
                return null;
            }

            @Override
            public Set<SelectionKey> keys() {
                return null;
            }

            @Override
            public Set<SelectionKey> selectedKeys() {
                return null;
            }

            @Override
            public int selectNow() throws IOException {
                return 0;
            }

            @Override
            public int select(long timeout) throws IOException {
                return 0;
            }

            @Override
            public int select() throws IOException {
                return 0;
            }

            @Override
            public Selector wakeup() {
                return null;
            }

            @Override
            public void close() throws IOException {

            }
        };
        Set<SelectionKey> selectionKeys = selector.selectedKeys();
        for (SelectionKey selectionKey:selectionKeys){
            SelectableChannel channel = selectionKey.channel();
            channel.blockingLock();
        }
    }
}
