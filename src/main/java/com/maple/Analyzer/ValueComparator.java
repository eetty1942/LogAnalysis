package com.maple.Analyzer;

import java.util.Comparator;
import java.util.Map;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class ValueComparator  implements Comparator<Object> {
    Map<String , Integer> base;

    public ValueComparator(Map<String , Integer> base)
    {
        this.base = base;
    }

    public int compare( Object a , Object b )
    {
        if((int)base.get(a) < (int)base.get( b ) )
        {
            return 1;
        }
        else if ( base.get( a ) == base.get( b ) )
        {
            return 0;
        }
        else
        {
            return - 1;
        }
    }
}
