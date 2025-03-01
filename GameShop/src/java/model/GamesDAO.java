
package model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import mylib.DBUtils;

/**
 *
 * @author THINH
 */
public class GamesDAO {

    public List<GamesDTO> list(String keyword, String sortCol) {
        List<GamesDTO> gameList = new ArrayList<GamesDTO>();
        try {
            Connection con = DBUtils.getConnection();
            String sql = "SELECT gameId, title, description, price, publisher, releaseDate,isDlc FROM games";
            if (keyword != null && !keyword.isEmpty()) {
                sql += " WHERE title like ?";
            }
            if (sortCol != null && !sortCol.isEmpty()) {
                sql += " ORDER BY " + sortCol + " ASC";
            }
            PreparedStatement stmt = con.prepareStatement(sql);
            if (keyword != null && !keyword.isEmpty()) {
                stmt.setString(1, "%" + keyword + "%");
            }
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                String gameId = rs.getString("gameId");
                String title = rs.getString("title");
                String description = rs.getString("description");
                double price = rs.getDouble("price");
                String publisher = rs.getString("publisher");
                Date releaseDate = rs.getDate("releaseDate");
                int isDlc = rs.getInt("isDlc");

                GamesDTO games = new GamesDTO();
                games.setTitle(title);
                games.setDescription(description);
                games.setgameId(gameId);
                games.setPrice(price);
                games.setPublisher(publisher);
                games.setReleaseDate(releaseDate);
                games.setIsDLC(isDlc);

                gameList.add(games);
            }
            con.close();
        } catch (SQLException ex) {
            System.out.println("Error in servlet. Details:" + ex.getMessage());
            ex.printStackTrace();
        }
        return gameList;
    }
}
