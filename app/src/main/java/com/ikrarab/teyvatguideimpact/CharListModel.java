package com.ikrarab.teyvatguideimpact;

import java.util.List;

public class CharListModel {

    private List<Types> types;

    public List<Types> getTypes() {
        return types;
    }

    public void setTypes(List<Types> types) {
        this.types = types;
    }

    public class  Types{
        private String characters;

        public String getCharacters() {
            return characters;
        }

        public void setCharacters(String characters) {
            this.characters = characters;
        }

        @Override
        public String toString() {
            return "Types{" +
                    "characters='" + characters + '\'' +
                    '}';
        }
    }

}
