package com.example.demo.utils.pcap2;

import com.example.demo.utils.file.FileUtil;
import io.pkts.PacketHandler;
import io.pkts.Pcap;
import io.pkts.buffer.Buffer;
import io.pkts.packet.Packet;
import io.pkts.protocol.Protocol;

import java.io.IOException;

/**
 * Created by wzj on 2017/10/26.
 */
public class PcapParser
{
    public static void main(String[] args) throws IOException
    {
        final Pcap pcap = Pcap.openStream("C:\\Users\\99686\\Desktop\\tyche\\医护管家_智柜\\qcap\\2020_0513_1535_19.pcap");

        pcap.loop(new PacketHandler()
        {
            @Override
            public boolean nextPacket(final Packet packet) throws IOException
            {
                if (packet.hasProtocol(Protocol.TCP))
                {
                    Buffer payload = packet.getPacket(Protocol.TCP).getPayload();
                    if (payload != null)
                    {
                        System.out.println(payload);
//                        FileUtil.writeTxt("C:\\Users\\99686\\Desktop\\123.txt",payload.toString());

                    }

                }

                return true;
            }
        });
    }
}