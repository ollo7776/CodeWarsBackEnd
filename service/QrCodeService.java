package com.reactcwqr.codewars.service;

import java.util.ArrayList;
import java.util.List;

public class QrCodeService extends DefaultService {
    private int[][] qrcode;

    @Override
    public String solve() {
        return scan(qrcode);
    }

    public int[][] getQrcode() {
        return qrcode;
    }
    public void setQrcode(int[][] qrcode) {
        this.qrcode = qrcode;
    }

    private String scan(int[][] qrcode) {
        List<Integer> bits = toBits(qrcode);
        readNext(bits, 4);
        int length = readNext(bits, 8);

        String text = "";
        for (int i = 0; i < length; i++) {
            text += readNext(bits, 8);
        }

        return text;
    }

    private List<Integer> toBits(int[][] qrcode) {
        List<Integer> bits = new ArrayList<>();
        int x = 20, y = 20, mask;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 12; j++) {
                mask = ((x + y) % 2 == 0) ? 1 : 0;
                bits.add(qrcode[y][x--] ^ mask);
                mask = ((x + y) % 2 == 0) ? 1 : 0;

                if (i % 2 == 0) {
                    bits.add(qrcode[y--][x++] ^ mask); //we go up
                } else {
                    bits.add(qrcode[y++][x++] ^ mask); //we go down
                }
            }
            x -= 2;
            if (i % 2 == 0) {
                y++;
            } else {
                y--;
            }
        }
        return bits;
    }

    private char readNext(List<Integer> bits, int lenght) {
        String text = "";

        for (int i = 0; i < lenght; i++) {
            text += bits.remove(0);
        }

        return (char) Integer.parseInt(text, 2);
    }


}
