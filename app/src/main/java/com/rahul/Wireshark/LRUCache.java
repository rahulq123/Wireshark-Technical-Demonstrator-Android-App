/***************************************************************************************
 Title: A packet interceptor for Android built on top of VpnService
 Author: hexene
 Date: 2015
 Type: Source Code
 Availability: https://github.com/hexene/LocalVPN

 ***************************************************************************************/

package com.rahul.Wireshark;

import java.util.LinkedHashMap;


public class LRUCache<K, V> extends LinkedHashMap<K, V>
{
    private int maxSize;
    private CleanupCallback callback;

    public LRUCache(int maxSize, CleanupCallback callback)
    {
        super(maxSize + 1, 1, true);

        this.maxSize = maxSize;
        this.callback = callback;
    }

    @Override
    protected boolean removeEldestEntry(Entry<K, V> eldest)
    {
        if (size() > maxSize)
        {
            callback.cleanup(eldest);
            return true;
        }
        return false;
    }

    public static interface CleanupCallback<K, V>
    {
        public void cleanup(Entry<K, V> eldest);
    }
}
