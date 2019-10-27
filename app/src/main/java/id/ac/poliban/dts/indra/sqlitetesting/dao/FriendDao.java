package id.ac.poliban.dts.indra.sqlitetesting.dao;

import java.util.List;

import id.ac.poliban.dts.indra.sqlitetesting.domain.Friend;

public interface FriendDao {
        void insert(Friend f);
        void update(Friend f);
        void delete(int id);
        Friend getAFriendById(int id);
        List<Friend>getAllFriends();

}
