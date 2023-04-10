package com.edu.system;

import com.edu.system.controller.BookContorller;

import java.util.Scanner;

public class BookMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        new BookContorller().menu(sc);
    }
}
