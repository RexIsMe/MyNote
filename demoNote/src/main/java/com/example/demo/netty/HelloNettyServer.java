package com.example.demo.netty;


import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;

/**
 * @author lizhiqiang
 * @description netty体验
 * @create 2024/3/5 14:28
 */
public class HelloNettyServer {

    private static final Integer port = 8080;

    public static void main(String[] args) throws InterruptedException {
        //设置线程组
        NioEventLoopGroup bossGroup = new NioEventLoopGroup();
        NioEventLoopGroup workerGroup = new NioEventLoopGroup();

        try {
            //启动引导
            ServerBootstrap bootstrap = new ServerBootstrap();
            bootstrap.group(workerGroup, workerGroup)
                    .channel(NioServerSocketChannel.class)
                    .childHandler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel socketChannel) throws Exception {
                            ChannelPipeline pipeline = socketChannel.pipeline();
                            //加入自定义的handler处理器
                            pipeline.addLast(new HelloNettyServerHandler());
                        }
                    });

            //绑定端口号
            ChannelFuture future = bootstrap.bind(port).sync();

            //等待服务端监听端口关闭
            future.channel().closeFuture().sync();
        } finally {
            //关闭资源
            bossGroup.shutdownGracefully();
            workerGroup.shutdownGracefully();
        }

    }
}
