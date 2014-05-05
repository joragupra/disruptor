package com.joragupra.disruptorSample;

import com.lmax.disruptor.dsl.Disruptor;
import com.lmax.disruptor.RingBuffer;
import java.nio.ByteBuffer;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class LongEventMain  {

    public static LongEvent createLongEvent() {
        return new LongEvent();
    }

    public static void handleEvent(LongEvent event, long sequence, boolean endOfBatch) {
        System.out.println(event);
    }

    public static void translate(LongEvent event, long sequence, ByteBuffer buffer) {
        event.set(buffer.getLong(0));
    }

    public static void main( String[] args ) throws Exception {
        Executor executor = Executors.newCachedThreadPool();
        int bufferSize = 1024;
        Disruptor<LongEvent> disruptor = new Disruptor<>(LongEventMain::createLongEvent, bufferSize, executor);
        disruptor.handleEventsWith(LongEventMain::handleEvent);
        disruptor.start();
        RingBuffer<LongEvent> ringBuffer = disruptor.getRingBuffer();
        ByteBuffer bb = ByteBuffer.allocate(8);
        for (long l = 0; true; l++) {
        	bb.putLong(0, l);
        	ringBuffer.publishEvent(LongEventMain::translate, bb);
        	Thread.sleep(1000);
        }
    }

}
