package com.line.parser;

import com.line.domain.Hospital;

public class HospitalParser implements Parser<Hospital> {

    @Override
    public Hospital parse(String str) {
        str = str.replaceAll("\"", "");
        String[] splitted = str.split(",");
        return new Hospital(splitted[0], splitted[1], splitted[2], splitted[6], splitted[10], getSubdivision(splitted[10], splitted[8]));
    }

    public String getSubdivision(String name, String note) {

        if (name.contains("내과") || note.contains("내과")) {
            note = "내과";
        } else if (name.contains("피부") || note.contains("피부")) {
            note = "피부과";
        } else if (name.contains("성형") || note.contains("성형")) {
            note = "성형외과";
        } else if (name.contains("치과") || note.contains("치과")) {
            note = "치과";
        } else if (name.contains("한의원") || note.contains("한의원")) {
            note = "한의원";
        } else if (name.contains("소아") || note.contains("소아")) {
            note = "소아";
        } else if (name.contains("가정의학") || note.contains("가정의학")) {
            note = "가정의학과";
        } else if (name.contains("정형") || note.contains("정형")) {
            note = "정형외과";
        } else if (name.contains("부인") || note.contains("부인")) {
            note = "산부인과";
        } else if (name.contains("대학") || note.contains("대학")) {
            note = "대학병원";
        } else if (name.contains("외과") || note.contains("외과")) {
            note = "외과";
        } else note = "";

        return note;
    }
}