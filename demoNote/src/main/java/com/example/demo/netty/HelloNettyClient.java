package com.example.demo.netty;


import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;

import java.net.InetSocketAddress;

/**
 * @author lizhiqiang
 * @description TODO
 * @create 2024/3/5 14:30
 */
public class HelloNettyClient {

    private static final String host = "127.0.0.1";
    private static final Integer port = 8080;

    public static void main(String[] args) throws InterruptedException {
        NioEventLoopGroup group = new NioEventLoopGroup();

        try {
            Bootstrap bootstrap = new Bootstrap();
            bootstrap.group(group)
                    .channel(NioSocketChannel.class)
                    .remoteAddress(new InetSocketAddress(host, port))
                    .handler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel socketChannel) {
                            socketChannel.pipeline().addLast(new HelloNettyClientHandler());
                        }
                    });

            ChannelFuture sync = bootstrap.connect().sync();

            sync.channel().closeFuture().sync();
        } finally {
            group.shutdownGracefully().sync();
        }
    }
}
