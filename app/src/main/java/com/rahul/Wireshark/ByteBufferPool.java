/***************************************************************************************
 Title: A packet interceptor for Android built on top of VpnService
 Author: hexene
 Date: 2015
 Type: Source Code
 Availability: https://github.com/hexene/LocalVPN

 ***************************************************************************************/


package com.rahul.Wireshark;

import java.nio.ByteBuffer;
import java.util.concurrent.ConcurrentLinkedQueue;

public class ByteBufferPool
{
    private static final int BUFFER_SIZE = 16384; // XXX: Is this ideal?
    private static ConcurrentLinkedQueue<ByteBuffer> pool = new ConcurrentLinkedQueue<>();

    public static ByteBuffer acquire()
    {
        ByteBuffer buffer = pool.poll();
        if (buffer == null)
            buffer = ByteBuffer.allocateDirect(BUFFER_SIZE); // Using DirectBuffer for zero-copy
        return buffer;
    }

    public static void release(ByteBuffer buffer)
    {
        buffer.clear();
        pool.offer(buffer);
    }

    public static void clear()
    {
        pool.clear();
    }
}
