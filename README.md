Disruptor client code sample
============================

After reading about the LMAX architecture (http://martinfowler.com/articles/lmax.html), I was really curious about one of its most interesting components -the Disruptor. This is the component specially crafted by the LMAX team to handle concurrency.

On a very basic level (and there is much more to know about it), a Disruptor is the special queue where producers put objects on and will be sent to all consumers.

This code sample has been developed following the guidance provided in https://github.com/LMAX-Exchange/disruptor/wiki/Getting-Started.

For further reading about the Disruptor please check https://github.com/LMAX-Exchange/disruptor/wiki/Blogs-And-Articles.

I also find quite interesting the whole bunch of code made avaiable by the LMAX team https://github.com/LMAX-Exchange.
