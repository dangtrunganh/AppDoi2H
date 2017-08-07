package com.dt.anh.appdoi2h.controller;

import android.content.Context;
import android.media.MediaPlayer;
import android.net.Uri;
import android.util.Log;
import android.widget.Toast;

import com.dt.anh.appdoi2h.ListMusicFragment;
import com.dt.anh.appdoi2h.model.Song;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

/**
 * Created by ALIENWARE on 4/7/2017.
 */

public class MediaManager implements MediaPlayer.OnCompletionListener {
    private static final int IDE = 1;
    private static final int PLAYING = 2;
    private static final int STOPPED = 3;
    private static final int PAUSE = 4;

    private int mState = IDE;
    private MediaPlayer mPlayer;
    private int mIndex = 0;
    private boolean isShuffled;

    private static final String TAG = MediaManager.class.getName();
    private List<Song> mListSong;
    private Context mContext;

    public MediaManager(Context mContext) {
        this.mContext = mContext;
        initData();

        mPlayer = new MediaPlayer();
        mPlayer.setOnCompletionListener(this);
    }

    public int getmIndex() {
        return mIndex;
    }

    private void initData() {
        mListSong = new ArrayList<>();
//        mListSong.add(new Song(name, album, artist, duration, ""));
        String name = "Anh tình nguyện";
        String artist = "Không rõ";
        int duration = 201000;
        String link = "http://dangtrunganh.com/music/Anh%20T%C3%ACnh%20Nguy%E1%BB%87n.mp3";
        String lyric = "\tAnh vẫn đứng dù trời gió mưa giăng khắp lối, dù cho những lúc nắng cháy đen thui cả da cả người. Anh đứng dưới ánh nắng mang niềm tin hi vọng, nụ cười trên môi xoá hết âu lo. Em bước đến hỏi đường ra ngã tư Minh Khai, hỏi xem xe bus số mấy để ra tận nơi bây giờ. Em hãy đến bến trên Bạch Mai kia kìa, hỏi xe 26 là sẽ đến ngay.\n" +
                "\tLà nơi đáng tin cho em đến để hỏi đường, là nơi ấm êm em tìm trong khi bỡ ngỡ, Anh dang cánh tay đón lấy em vào trường. Đoạn đường ta đi tuy xa mà thật gần. Anh lắng nghe tim mình chợt thấy xuyến xao làm sao. Nguyện đi với em suốt con đường trường dù cho cánh tay rã rời khi xách túi, thì em hãy tin khi có anh dẫn đường, đặt vào tay anh ba lô to cùng đồ đạc. Cầu mong cho em thi đỗ vào trường kinh tế và yêu anh.\n";
        mListSong.add(new Song(name, artist, duration, link, lyric));

        //=============================

        name = "Áo xanh tình nguyện";
        artist = "Không rõ";
        duration = 180000;
        link = "http://dangtrunganh.com/music/%c3%81o%20Xanh%20T%c3%acnh%20Nguy%e1%bb%87n%20-%20Copy.mp3";
        lyric = "\tXanh xanh màu quê hương, màu áo xanh trên mọi tuyến đường. Nhanh nhanh từng bước chân bao khát khao tuổi xuân ước mơ. Đến với những con đường thật xa, dẫu biết trước khó khăn chờ ta. Hát lên nào bạn ơi.\n" +
                "\tHát lên nào khúc ca từ trái tim cùng vì ngày mai, những tiếng cười em thơ vang trong ta niềm vui mới. Những công trình đã xây từ cánh tay tình nguyện hôm nay, sáng mãi tâm hồn niềm tin.\n";
        mListSong.add(new Song(name, artist, duration, link, lyric));
        //=============================
        name = "Bình minh sinh viên";
        artist = "Bức Tường";
        duration = 226000;
        link = "http://dangtrunganh.com/music/B%c3%acnh%20Minh%20Sinh%20Vi%c3%aan.mp3";
        lyric = "\tBình minh đang đến bên nơi chân trời, màn sương đêm đang dần tan. Trăm ngàn ánh mắt đang sáng bừng lên cả không gian chan hòa ánh nắng, và ta đã hát từ trong con tim, một kỷ nguyên mới đã lên. Bao niềm vinh quang đang chờ đón ta, người sinh viên thời đại mới.\n" +
                "\tMặt trời vừa lên chiếu sáng trên thành phố xôn xao, làm con tim ta như nghe rộn rã. Và xa xa âm vang nhà máy reo ca, một thành phố sức sống dâng trào. Ngày hôm nay thênh thang con đường mới, bình minh sinh viên năm 2000.\n" +
                "\tNgười mẹ thân thương cho ta một trái tim son làm cho ta thêm tin yêu cuộc sống, niềm vinh quang sinh viên thế kỷ mới ta đi nhờ đôi mắt sáng sáng chân trời rộng. Ngày hôm nay vươn lên tầm cao mới, bình minh sinh viên năm 2000.\n" +
                "\tHát lên bài ca bình minh sinh viên năm 2000! Hát lên bài ca bình minh sinh viên Việt Nam.\n";
        mListSong.add(new Song(name, artist, duration, link, lyric));


        //=============================
        name = "Chỉ thế thôi";
        artist = "Đặng Việt";
        duration = 224000;
        link = "http://dangtrunganh.com/music/Ch%e1%bb%89%20Th%e1%ba%bf%20Th%c3%b4i.mp3";
        lyric = "Dù nắng dẫu gió hay là lúc đông lạnh về\n" +
                "Mọi nơi thôn quê xa gần cũng không ngại ngần\n" +
                "Dù bao chông gai không làm chúng ta nản lòng\n" +
                "Cùng dang đôi tay mang nụ cười đến muôn nơi.\n" +
                "\n" +
                "Tự tin đi lên khi mặc áo xanh màu Đoàn\n" +
                "Cầu tre ta xây những nhịp kết nối tương lai\n" +
                "Màu xanh thân thương dẫu bụi những khi chỉ đường\n" +
                "Mà sao vui ghê những giờ phút ấy\n" +
                "\n" +
                "Đi lên thanh niên chung vai chúng ta tự tin bước vào đời\n" +
                "Bay cao bay xa khi bao ước mơ đã đến rất gần\n" +
                "Đoàn viên ta đi lên xông pha mang bao niềm vui đến cho đời\n" +
                "Màu xanh yêu thương trong tim này mãi mãi\n" +
                "\n" +
                "Mang trong tim kiêu hãnh dòng máu Lạc Hồng\n" +
                "Tuổi xanh ta đi không nghĩ suy đắn đo chi\n" +
                "Để bao em thơ yên bình cắp sách tới trường\n" +
                "Sẽ luôn là tiếng cười vang vọng muôn nơi\n" +
                "\n" +
                "Truyền thống cha ông ta quyết tâm mãi giữ gìn\n" +
                "Dựng xây tương lai câu hứa kia mãi không phai\n" +
                "Để ta phiêu du góp sức cống hiến cho đời\n";
        mListSong.add(new Song(name, artist, duration, link, lyric));


        //=============================
        name = "Dân vũ";
        artist = "Không rõ";
        duration = 274000;
        link = "http://dangtrunganh.com/music/D%c3%a2n%20V%c5%a9.mp3";
        lyric = "(Không lời)";
        mListSong.add(new Song(name, artist, duration, link, lyric));


        //=============================
        name = "Dấu chân tình nguyện";
        artist = "Vũ Hoàng";
        duration = 201000;
        link = "http://dangtrunganh.com/music/D%e1%ba%a5u%20Ch%c3%a2n%20T%c3%acnh%20Nguy%e1%bb%87n.mp3";
        lyric = "\tNhững trái tim như ngọn lửa hồng, lòng khát khao tình yêu cuộc sống. Như cánh chim trời tung bay, góp sức tô đẹp tương lai, nối đất trời vòng tay thân ái.\n" +
                "\tVách núi cao vang lời gọi mời. Về biển khơi tài nguyên lên tiếng. Thôi thúc sức trẻ hôm nay, đất nước mong chờ đôi tay, những công trình vươn mình đẹp thay.\n" +
                "\tLên rừng xuống biển, dưới cờ Đảng quang vinh ta tiến vào kỷ nguyên mới. Không ngại gian khổ, những dấu chân tình nguyện chinh phục những đỉnh cao, những dấu chân tình nguyện dệt những ước mơ xa.\n";
        mListSong.add(new Song(name, artist, duration, link, lyric));

        //=============================
        name = "Đội SVTN Đồng hương Quảng Ninh - Hai Hòn một trái tim";
        artist = "Không rõ";
        duration = 216000;
        link = "http://dangtrunganh.com/music/%c4%90%e1%bb%99i%20SVTN%20%c4%90%e1%bb%93ng%20h%c6%b0%c6%a1ng%20Qu%e1%ba%a3ng%20Ninh%20-%20Hai%20H%c3%b2n%20M%e1%bb%99t%20Tr%c3%a1i%20Tim.mp3";
        lyric = "Ngày mai chúng ta sẽ phải xa nhau\n" +
                "Ngồi lại đây ta sớt chia hơi ấm cho nhau\n" +
                "Nghẹn nào tiếng nấc trong tim\n" +
                "Và bờ môi run run không nên lời\n" +
                "Lòng thầm mong ta sẽ mãi không rời xa\n" +
                "\n" +
                "Bạn hỡi hãy quên đi nỗi buồn\n" +
                "Dù xa cách ta vẫn luôn luôn nhớ về\n" +
                "Từng phút ấm áp bên nhau\n" +
                "Từng bàn tay từng đôi mắt\n" +
                "Và giờ đây ngồi bên nhau ta hát\n" +
                "\n" +
                "Cùng hát hai tiếng thân thương mãi Hai Hòn\n" +
                "Hai tiếng trong tim mãi Hai Hòn\n" +
                "Cùng bên nhau, cùng vượt qua khó khăn.\n" +
                "\n" +
                "Ngày mai dẫu có đi bốn phương trời\n" +
                "Vẫn nhớ về mái ấm Hai Hòn\n" +
                "Dù xa cách, dù nơi đâu, ta sẽ\n" +
                "Không bao giờ quên…";
        mListSong.add(new Song(name, artist, duration, link, lyric));


        //=============================
        name = "Đồng đội";
        artist = "Hoàng Hiệp";
        duration = 284000;
        link = "http://dangtrunganh.com/music/%C4%90%E1%BB%93ng%20%C4%90%E1%BB%99i.mp3";
        lyric = "\tChúng tôi ngồi kề vai bên nhau, trăng trôi qua đầu súng, ánh lửa hồng bừng soi đêm thâu, làn khói che sương mờ. Bạn tôi đang mơ, nơi làng quê yêu dấu, có con kênh đào, lúa xanh hai mùa mát cánh đồng. Còn tôi đang mơ, mơ người tôi yêu dấu, cách xa muôn dặm mà lòng không xa.\n" +
                "\tChúng tôi nằm đầu gối lên tay, nghe chim kêu ngoài bãi. Mắt đưa nhìn trời sao lung linh, chuyện mải quên đêm dài. Bạn tôi cho hay, sau này xong chiến đấu, sẽ lên nông trường, sớm hôm trên đồng lái máy cày. Còn tôi mong sao bao ngày tôi đang sống, sẽ không bao giờ mờ nhạt mai sau.\n" +
                "\tDưới khu rừng ngàn năm âm u, nơi biên cương chùa tháp, chúng tôi thường đổi trao suy tư cùng thắp ngọn lửa hồng. Cùng chia cho nhau, bao hiểm nguy gian khó, giữa cơn mưa nguồn, những đêm lưng tựa vách chiến hào. Nhiều khi vui sao, đang hành quân chiến đấu, lá thư quê nhà chuyền tay trao nhau.\n";
        mListSong.add(new Song(name, artist, duration, link, lyric));


        //=============================
        name = "Dưới ánh mai hồng";
        artist = "Trần Đình Văn";
        duration = 184000;
        link = "http://dangtrunganh.com/music/D%c6%b0%e1%bb%9bi%20%c3%81nh%20Mai%20H%e1%bb%93ng.mp3";
        lyric = "\tDưới ánh mai hồng bạn ơi ta đi, nào cùng thắp lên trong lòng mình ngọn lửa. Tiếng Bác Hồ còn vang trong tim, nào cùng hát lên ta qua mọi nẻo đường.\n" +
                "\tNhiễu điều phủ lấy giá gương, từng lời thiêng liêng ngàn đời vọng lại. Ấm nồng vòng tay yêu thương, nào cùng hát lên ta qua mọi nẻo đường.\n" +
                "\tBiển sâu non cao, làng quê phương xa. Bạn ơi ta đi, vì từng mái tranh đã qua mùa giông bão, vì từng xóm thôn đã bao mùa tần tảo. Vì các mẹ già, vì các em thơ… (Đoàn ta đi)×2 sưởi ấm tình người, để ngày mai, tươi sáng những nụ cười. (Dưới ánh mai hồng bạn ơi ta đi)×3.\n";
        mListSong.add(new Song(name, artist, duration, link, lyric));


        //=============================
        name = "Hải Dương xanh";
        artist = "Không rõ";
        duration = 149000;
        link = "http://dangtrunganh.com/music/H%e1%ba%a3i%20D%c6%b0%c6%a1ng%20Xanh.mp3";
        lyric = "Màu áo xanh tình nguyện một thời sinh viên…Áo xanh..\n" +
                "Cùng chúng tôi hát vang trên mọi nẻo đường…Áo xanh…\n" +
                "Tôi đi tôi đi qua từng thôn xóm bản làng\n" +
                "In dấu chân bè bạn sâu đậm trong tim\n" +
                "\n" +
                "Màu áo xanh tình nguyện một thời sinh viên…Áo xanh…\n" +
                "Ngày hôm qua tôi ươm mầm xanh trên rẫy\n" +
                "Từng giọt mồ hôi rơi rơi thấm trên đất cằn bao đời\n" +
                "Cho đàn em thơ vui chơi\n" +
                "Cùng sống chung trong một gia đình\n" +
                "\n" +
                "Lời hứa chúng tôi lên đường đi tới chân trời xa\n" +
                "Dù biết khó khăn đang chờ\n" +
                "Hành trang trên vai tình nguyện\n" +
                "Còn gì đẹp bằng chúng tôi mang theo tình quê hương\n";
        mListSong.add(new Song(name, artist, duration, link, lyric));


        //=============================
        name = "Hành khúc thanh niên tình nguyện";
        artist = "Thế Hiển";
        duration = 204000;
        link = "http://dangtrunganh.com/music/H%c3%a0nh%20Kh%c3%bac%20Thanh%20Ni%c3%aan%20T%c3%acnh%20Nguy%e1%bb%87n.mp3";
        lyric = "\tChúng ta hát bài ca thanh niên tình nguyện. Chúng ta đến vùng sâu nơi xa mọi miền. tuổi trẻ có thanh niên, đầy nhiệt huyết trong tim, bạn cùng tôi hòa mình vào mùa hè xanh.\n" +
                "\tVới khối óc bàn tay hăng say nhiệt tình, góp công sức dựng xây quê hương của mình. Tuổi trẻ sống hôm nay và hạnh phúc mai sau. Mùa hè xanh giục giã bước nhanh lên đường.\n" +
                "\tVề đồng bằng phương nam ta đắp đê ngăn cơn lũ tràn. Dạy đàn em học hành, dựng căn nhà cho người neo đơn. Ta đi lên Trường Sơn mở con đường lịch sử hào hùng. Ta đi lên vùng cao giúp đồng bào trồng cây gây rừng.\n" +
                " \tÁo xanh thắm đoàn ta thanh niên tình nguyện. Những năm tháng nào phai trong ta kỷ niệm. Đời cần có thanh  niên đầy nhựa sống trong tim. Mùa hè xanh hát vang bài ca lên đường.\n";
        mListSong.add(new Song(name, artist, duration, link, lyric));


        //=============================
        name = "Hành khúc xanh";
        artist = "Không rõ";
        duration = 114000;
        link = "http://dangtrunganh.com/music/H%c3%a0nh%20Kh%c3%bac%20Xanh.mp3";
        lyric = "\tTa mang trên mình màu áo xanh tươi, màu trời Việt Nam, màu xanh cuộc đời . Muôn trái tim hồng vì Tổ Quốc yêu thương, tương lai tươi sáng cùng dựng xây quê hương.\n" +
                "\tĐây thanh niên Việt Nam, chiếc áo mang tình đất nước mến trao. Đây cánh mũ tai bèo, bài ca ghi tiếp chiến công tự hào. Trùng điệp trùng màu áo xanh tươi, vai sát vai lớp lớp bước tới. (Tổ Quốc mến yêu ơi, đây sức xuân dâng Người)×2.\n";
        mListSong.add(new Song(name, artist, duration, link, lyric));


        //=============================
        name = "Hát cho những tương lai Việt Nam";
        artist = "Không rõ";
        duration = 319000;
        link = "http://dangtrunganh.com/music/H%c3%a1t%20Cho%20Nh%e1%bb%afng%20T%c6%b0%c6%a1ng%20Lai%20Vi%e1%bb%87t%20Nam.mp3";
        lyric = " Một năm đã qua ta lại về đây, cầm tay nhau ta hát cho tương lai trẻ thơ. Vì mai sau tươi sáng cho nhân loại, hãy chung tay với đời, xóa tan đi nghèo đói gian lao bao ngày.\n" +
                "\tKìa anh công nhân đến cô sinh viên má hồng, đạp xe thong dong bác xích lô đang cười duyên. Tà áo tung bay trắng muôn góc trời, e ấp môi mỉm cười, nét thân thương cháy lên Việt Nam tuyệt vời.\n" +
                "\tDuyên dáng Việt Nam, cánh tay ôm người tha hương, những đứa con tìm về chốn cũ yêu thương hòa với tiếng hát vang. Duyên dáng Việt Nam bắc - trung - nam một đôi tay, nắm tay một lòng hát khúc dân ca hòa với tiếng nhạc tình hân hoan.\n" +
                "\tBạn hãy chung tay với tôi, là thanh niên cùng chung vai, kìa bầu trời dưới ánh nắng mai. Câu hát này, xin giúp đời và xin được riêng hát cho, những tương lai Việt Nam.\n";
        mListSong.add(new Song(name, artist, duration, link, lyric));

        //=============================
        name = "Hãy đến với con người Việt Nam tôi";
        artist = "Xuân Nghĩa";
        duration = 245000;
        link = "http://dangtrunganh.com/music/H%c3%a3y%20%c4%90%e1%ba%bfn%20V%e1%bb%9bi%20Con%20Ng%c6%b0%e1%bb%9di%20Vi%e1%bb%87t%20Nam%20T%c3%b4i.mp3";
        lyric = "Này bạn thân nơi năm châu bốn phương\n" +
                "Việt Nam đất nước chúng tôi xin chào\n" +
                "Ngày nào còn chìm trong khói bom\n" +
                "Mà giờ đây cất cao lời ca vang. \n" +
                "\n" +
                "Hà nội thủ đô con tim dấu yêu\n" +
                "Ngược xuôi phố xá đã vui thêm nhiều\n" +
                "Tàu vào Nam rộn vang tiếng ca\n" +
                "Ngàn bàn tay vẫy nhau chào tương lai. \n" +
                "\n" +
                "Sài Gòn hôm nay bao nhiêu đổi thay\n" +
                "Hoà theo sức sống với bao công trình\n" +
                "Từ bàn tay cùng nhau đắp xây\n" +
                "Để giờ đây chúng tôi gọi mời.\n" +
                "\n" +
                "Hãy đến với những con người Việt Nam tôi\n" +
                "Đến với quê hương đất nước thanh bình\n" +
                "Đến với tết đón giao thừa ngày ba mươi\n" +
                "Với những chiến công mùa xuân năm ấy. \n" +
                "\n" +
                "Quê hương tôi đây đã sống hôm qua\n" +
                "Quê hương tôi đây vẫn sáng hôm nay\n" +
                "Quê hương tôi đây sẽ mãi mai sau\n" +
                "Vang danh non sông trái tim Việt Nam.\n" +
                "\n" +
                "Một ngày cha ông vang danh núi sông\n" +
                "Một ngày đất nước đứng lên thanh bình\n" +
                "Ngày dựng xây cùng bao cánh tay\n" +
                "Ngày hôm nay bước lên cùng anh em.\n" +
                "\n" +
                "Mảnh đạn năm xưa gieo trên đất nâu\n" +
                "Giờ đây đã hoá những thân lúa vàng\n" +
                "Gởi vào trong từng trang sách thơ\n" +
                "Chờ tương lai trái tim mỉm cười.\n";
        mListSong.add(new Song(name, artist, duration, link, lyric));

        //=============================
        name = "Khát vọng tuổi trẻ";
        artist = "Vũ Hoàng";
        duration = 243000;
        link = "http://dangtrunganh.com/music/Kh%c3%a1t%20V%e1%bb%8dng%20Tu%e1%bb%95i%20Tr%e1%ba%bb.mp3";
        lyric = "\tĐường dài tương lai quê hương đang gọi mời. Tuổi trẻ tương lai chung tay xây ngày mới. Dù lên rừng hay xuồng biển. Vượt bão dông, vượt gian khổ. Tuổi trẻ kề vai, vững vàng chân bước bạn ơi.\n" +
                "\t(Đừng hỏi Tổ Quốc đã làm gì cho ta, mà cần hỏi ta đã làm gì cho Tổ Quốc hôm nay. )×2\n";
        mListSong.add(new Song(name, artist, duration, link, lyric));


        //=============================
        name = "Khúc ca lên đường";
        artist = "Không rõ";
        duration = 252000;
        link = "http://dangtrunganh.com/music/Kh%c3%bac%20Ca%20L%c3%aan%20%c4%90%c6%b0%e1%bb%9dng.mp3";
        lyric = "\tNào bạn ơi chúng ta vui lên đường. Tuổi 20 đem sức xuân dâng đời nhựa sống. Nhìn non sông lung linh gấm hoa, Đoàn ta đi âm vang tiếng ca, tình quê hương như nâng cánh ta bay vào ngày mới.\n" +
                "\tBình minh lên bóng đêm đã tan rồi. Mùa xuân sang nghe líu lo trên cành chim hót. Giọt lệ đau thương nay đã vơi, nụ cười long lanh trên khóe môi, bạn cùng tôi ta đi khắp nơi xây đời xanh tươi.\n" +
                "\tVượt đèo cao (dô ta), qua sông dài (dô hò). Ta đi tới những chân trời. Rộn ràng những bước chân, vượt ngàn muôn khó khăn. Nào bạn ơi ta hát, hát khúc ca lên đường.\n";
        mListSong.add(new Song(name, artist, duration, link, lyric));


        //=============================
        name = "Khúc hát màu xanh";
        artist = "Không rõ";
        duration = 217000;
        link = "http://dangtrunganh.com/music/Kh%c3%bac%20H%c3%a1t%20M%c3%a0u%20Xanh.mp3";
        lyric = "\tThanh niên ta lên rừng xuống biển, vì tương lai non nước Việt Nam. Đẹp làm sao cháu con lạc hồng, thỏa tình yêu quê hương chờ mong.\n" +
                "\tMang trong tim ân tình sâu nặng, về làng quê chung sức dựng xây, đặt lên những dấu chân tình nguyện, rộn ràng hỡi trái tim Việt Nam.\n" +
                "\tĐời sẽ mãi tiếp bước, vì non sông quê hương, cùng về đây ta đắp xây cho một ngày mới. Rộn ràng tiếng hát tiếng hát, từng đàn em thơ ca vang, mùa hè xanh vang khúc ca yêu thương nghĩa tình.\n";
        mListSong.add(new Song(name, artist, duration, link, lyric));


        //=============================
        name = "Lá cờ";
        artist = "Không rõ";
        duration = 324000;
        link = "http://dangtrunganh.com/music/L%c3%a1%20C%e1%bb%9d.mp3";
        lyric = "Tôi lớn lên khi đất nước không còn chia Bắc- Nam\n" +
                "Chẳng biết chiến tranh là gì, chỉ được nghe trong những câu chuyện của cha\n" +
                "Tôi lớn lên khi tháng tháng không còn lo phiếu tem\n" +
                "Không biết Bobo là gì, chỉ còn lại trong những ký ức của mẹ\n" +
                "\n" +
                "Chuyện của cha tôi, Là những giấc mơ dở dang\n" +
                "Là xếp bút nghiên, chiến đấu vì một màu cờ đỏ tươi thấm máu bao người\n" +
                "Chuyện của mẹ tôi, Là cất tiếng ca cho đời\n" +
                "Là đến những nơi xa xôi với những con người cài ngôi sao vàng trên mũ\n" +
                "\n" +
                "Một thời chiến đấu cha tôi anh hùng\n" +
                "Một thời gian khó mẹ tôi đảm đang\n" +
                "Vẫn giữ nụ cười và tiếng hát át tiếng bom\n" +
                "Để rồi nay bước trên con đường đời\n" +
                "Dù bao gian khó, chông gai đời tôi\n" +
                "Thì đứng dưới bóng cờ, là con tim ngân lên tiếng ca :\n" +
                "'Đoàn quân Việt Nam đi...'\n" +
                "\n" +
                "Rồi ngày tháng trôi\n" +
                "Bao đổi thay đến với cuộc đời\n" +
                "Thì trong trái tim tôi luôn tự hào là người Việt Nam\n" +
                "Màu cờ thắm tươi vẫn phấp phới với những cuộc đời\n" +
                "Lòng bồi hồi nhớ..\n";
        mListSong.add(new Song(name, artist, duration, link, lyric));


        //=============================
        name = "Làm tình nguyện hết mình";
        artist = "Không rõ";
        duration = 298000;
        link = "http://dangtrunganh.com/music/L%c3%a0m%20t%c3%acnh%20nguy%e1%bb%87n%20h%e1%ba%bft%20m%c3%acnh.mp3";
        lyric = "Đi dọn rác, vớt kim tiêm,đi tuyên truyền cho bà con không mắc nghiện\n" +
                "Đi khuyên chị em đông con hãy nên đặt vòng,đi phát áo mưa cho các anh chồng.\n" +
                "Đi lên núi, ra đảo xa,giữ biên cương và biển trời Tổ Quốc ta\n" +
                "Bầu đây, hãy thương lấy Bí này,thương nhau tay nắm lấy bàn tay.\n" +
                "\n" +
                "Tôi đi làm tình...đi làm tình...đi làm tình nguyện viên\n" +
                "Tôi sẽ hết mình...sẽ nhiệt tình...suốt quãng đời sinh viên\n" +
                "Tôi sẽ hát những khúc ca mang đến cho cuộc đời\n" +
                "Tình yêu đến từ khắp mọi nơi...\n" +
                "\n" +
                "Tôi đi làm tình...đi làm tình...đi làm tình nguyện viên\n" +
                "Tôi sẽ hết mình, tôi mặc kệ, ai nói tôi điên\n" +
                "Tôi không muốn nói những thứ cao sang trên trời\n" +
                "Chỉ đơn giản là bạn bên tôi......\n" +
                "\n" +
                "Làm tình nguyện hết mình thôi!\n" +
                "\n" +
                "Đi tiếp sức, giúp mùa thi,gác bến xe, làm hậu cần, làm giám thị\n" +
                "Đi xin bà con cho thí sinh mượn phòng,đi phân luồng kết hợp giao thông.\n" +
                "Trong thành phố, hay tỉnh xa,khắp nơi nơi đều một màu xanh chúng ta\n" +
                "Rồi đây, vươn ra thế giới này,tương lai đất nước đổi thay.\n" +
                "\n" +
                "Dù cho ngàn khó khăn đang đón chờ ta,chỉ cần không chùn bước, ta sẽ vượt qua\n" +
                "Tôi luôn vững tin có một ngày,bạn và tôi, ta chung tay thay đổi thế giới nơi đây...\n";
        mListSong.add(new Song(name, artist, duration, link, lyric));


        //=============================
        name = "Mùa hè sinh viên";
        artist = "Phạm Đăng Khương";
        duration = 211000;
        link = "http://dangtrunganh.com/music/M%c3%b9a%20H%c3%a8%20Sinh%20Vi%c3%aan.mp3";
        lyric = "\tTạm biệt ghế nhà trường ta lại đến với mùa hè xanh. Xanh biển, xanh rừng, xanh cây, xanh lá. Bàn chân ta qua, xanh miền đất lạ. Đi xây cuộc đời xanh những bài ca.\n" +
                "\tĐời sinh viên như những trang thơ. Mùa hè xanh cho ta những ước mơ. Những miền quê đang chờ đón, từng đàn em đang mong ngóng, ngại gì sương gió, khó khăn nề chi.\n" +
                "\tĐời sinh viên những chuyến đi xa, lòng càng thêm yêu tha thiết quê nhà. Nụ cười trên môi rạng rỡ, từng ngày trong tim vẫn nhớ. Mùa hè ghi dấu một thời sinh viên.\n";
        mListSong.add(new Song(name, artist, duration, link, lyric));


        //=============================
        name = "Mùa hè xanh";
        artist = "Không rõ";
        duration = 254000;
        link = "http://dangtrunganh.com/music/M%c3%b9a%20H%c3%a8%20Xanh.mp3";
        lyric = "\tTựa đàn chim tung bay trên những nhịp cầu tre. Mùa hè xanh xôn xao nâng bước chân ta về. Đường làng quê tiếng ve như gọi mời say mê. Ngoài bờ đê có con trâu già nằm ngủ mê. Mùa hè xanh long lanh trong mắt đàn trẻ thơ. Trường làng quê cho em trang sách mới i tờ. Ngoài đồng xa có nghe bao giọt mồ hôi rơi. Để màu xanh vút lên trên ruộng đồng ngát hương.\n" +
                "\tMùa hè xanh, mùa hè xanh. Bao yêu thương, ơi mùa hè xanh vẫn vương. Đi muôn phương lưu luyến tình quê hương. Trong tim ta ơi mùa hè xanh thiết tha. Vang câu ca trên những chặng đường xa.\n";
        mListSong.add(new Song(name, artist, duration, link, lyric));


        //=============================
        name = "Thanh niên tình nguyện";
        artist = "Không rõ";
        duration = 184000;
        link = "http://dangtrunganh.com/music/Thanh%20Ni%c3%aan%20T%c3%acnh%20Nguy%e1%bb%87n.mp3";
        lyric = "\tNhìn về mùa xuân ta đi lên ngàn, nhìn về ngày mai ta theo sông dài, hiến dâng cho dời. Tự hào ngàn năm cha ông anh hùng, thời đại ngày nay ta đi xây đời, ta đi lập thân.\n" +
                "\tĐi ta đi hiến dâng cho đời nguyện dâng quê hương sức xuân dâng trào.\n" +
                "\tHãy sống vì nhau những ước mơ xanh, xanh thật xanh. Hiến dâng ngày tháng xanh tuổi thanh niên chúng ta. Cháy lên lòng ta những khát khao hi sinh vì dân. Sống không ngại khó, không thờ ơ, không thở than.\n" +
                "\tĐi ta đi hiến dâng cho đời, nguyện dâng quê hương sức xuân dâng trào.\n" +
                "\tNhìn về mùa xuân ta đi lên ngàn, nhìn về ngày mai ta theo sông dài hiến dâng cho đời. Tự hào ngàn năm cha ông anh hùng, thời đại ngày nay ta đi xây đời ta đi lập thân.\n" +
                "\tHãy sống trào dâng thỏa chí thanh niên trên đường xa. Sống như là sống cho tình yêu không tính toan. Cháy lên bạn ơi những quyết tâm chung tay dựng xây. Tuổi xuân nguyện sống cho tình yêu Việt Nam ta nở hoa.\n";
        mListSong.add(new Song(name, artist, duration, link, lyric));


        //=============================
        name = "Tình ca người thợ mỏ";
        artist = "Không rõ";
        duration = 280000;
        link = "http://dangtrunganh.com/music/T%c3%acnh%20ca%20ng%c6%b0%e1%bb%9di%20th%e1%bb%a3%20m%e1%bb%8f.mp3";
        lyric = "\tBình minh đang lên, Hạ Long muôn màu, từng đoàn thuyền ra khơi,cánh buồm xa vời. Đi trong sớm mai này, bạn nghe chăng bản tình ca mới. Miền Đông thân yêu tiếng súng đang vang rền, trong mỗi ca lao động của người thợ mỏ, của vùng than có khí thế Chi Lăng, Bạch Đằng lịch sử, nghe tha thiết trong tâm hồn,thợ mỏ vào ca cũng là chiến sĩ, trung đoàn năm xưa nay đã thành sư đoàn.\n" +
                "\tQuảng Ninh thân yêu ơi! Trong tình yêu quê hương có một tấm lòng, dành cho em người mà anh yêu quý vô cùng. Vùng than thân yêu ơi! Xin nguyện vì người mà chiến đấu đến cùng. Khi quân thù liều lĩnh dám đến nơi đây, súng trong tay, anh cùng em sẽ chung một chiến hào. Mỗi khi tan ca, anh cùng em lại ghi thêm một chiến công...! Là la lá la...là la lá la.là la lá la, là la...\n";
        mListSong.add(new Song(name, artist, duration, link, lyric));


        //=============================
        name = "Tình ca tuổi trẻ";
        artist = "Không rõ";
        duration = 197000;
        link = "http://dangtrunganh.com/music/T%c3%acnh%20Ca%20Tu%e1%bb%95i%20Tr%e1%ba%bb.mp3";
        lyric = "\tBài tình ca đầu tiên ra đời trên biên giới, bản tình ca anh hát cho em bên dòng kênh xanh. Trời mây trong xanh và mắt em xanh. Tiếng hát ta làm vui cuộc đời, có chúng tôi dựng xây cho cuộc đời.\n" +
                "\tLa la lá là lá la là, la lá là lá la. Lúc đất nước con khó khăn là thanh niên ta xung phong. Tinh tinh tính tình tính tinh tình, tinh tính tình tính tinh. Lúc Tổ Quốc cần chúng ta là thanh niên ta sẵn sàng.\n" +
                "\tCòn gì vui đẹp hơn con đường ra phía trước, triệu bàn chân vững bước đi lên dưới cờ Đảng quang vinh. Hờn căm trong tim giặc phá biên cương, hãy giữ yên màu xanh cho cuộc đời, có chúng tôi cầm súng giữ cuộc đời.\n";
        mListSong.add(new Song(name, artist, duration, link, lyric));


        //=============================
        name = "Tình yêu mặt trời";
        artist = "Không rõ";
        duration = 123000;
        link = "http://dangtrunganh.com/music/T%c3%acnh%20Y%c3%aau%20M%e1%ba%b7t%20Tr%e1%bb%9di.mp3";
        lyric = "\tXin cho đôi ta yêu nhau không rời. Bao năm trôi qua vẫn yêu em thế thôi. Trong con tim anh chan chứa bao kỷ niệm. Để tình đôi ta ngập tràn nốt nhạc vui. Anh yêu em như tình yêu mặt trời. Như con sông sâu tìm về biển mênh mông. Và đôi ta sẽ mãi không xa rời. Vì anh yêu em, và yêu mãi thôi.\n" +
                "\tNày người yêu ơi trong tim anh luôn chỉ có em thôi. Anh luôn yêu em và chỉ là thế thôi.Tình đôi ta như mặt trăng mặt trời. Em đến bên anh thắp sáng con tim mong đợi!\n";
        mListSong.add(new Song(name, artist, duration, link, lyric));


        //=============================
        name = "Tuổi trẻ thế hệ bác hồ";
        artist = "Không rõ";
        duration = 193000;
        link = "http://dangtrunganh.com/music/Tu%e1%bb%95i%20Tr%e1%ba%bb%20Th%e1%ba%bf%20H%e1%bb%87%20B%c3%a1c%20H%e1%bb%93.mp3";
        lyric = "\tTừ biển khơi tới miền rừng núi cao. Cờ Đoàn ta mang ảnh Bác với tên Người vĩ đại. Hồ Chí Minh, công ơn của Bác như biển trời. Tình Người ấm trong tim ta trên đường chiến đấu\n" +
                "\tVì đất nước ta ra đi xây đời hạnh phúc cho mai sau,  thoả lòng mong ước của Bác Hồ đêm ngày hằng mong. Là công sức ta xây nên đất trời Tổ Quốc thêm xanh tươi thỏa lòng mong ước của Bác Hồ đêm ngày hằng mong.\n" +
                "\tLà thanh niên thế hệ Hồ Chí Minh. Vì ngày mai ta xây đắp những công trình vĩ đại. Đồng lúa trĩu bông quê ta nhà máy khói ngút trời. Cả Tổ Quốc trong tương lai ánh điện tỏa sáng.\n";
        mListSong.add(new Song(name, artist, duration, link, lyric));


        //=============================
        name = "Tuổi xuân tình nguyện";
        artist = "Nguyễn Văn Hiên";
        duration = 272000;
        link = "http://dangtrunganh.com/music/Tu%e1%bb%95i%20Xu%c3%a2n%20T%c3%acnh%20Nguy%e1%bb%87n.mp3";
        lyric = "\tMang trái tim tình nguyện ra đi lòng không lưu luyến. Mang trái tim tình nguyện, tuổi xuân sống cho mọi người.\n" +
                "\tTuổi trẻ ơi, thiết tha yêu đời, tuổi trẻ ơi, bay đến muôn nơi. Mang trái tim tình nguyện, mang trái tim tình nguyện vì quê hương chúng ta lên đường.\n";
        mListSong.add(new Song(name, artist, duration, link, lyric));


        //=============================
        name = "Vào đời";
        artist = "Không rõ";
        duration = 255000;
        link = "http://dangtrunganh.com/music/V%c3%a0o%20%c4%90%e1%bb%9di.mp3";
        lyric = "Cuộc đời là tia nắng ấm vòng tay em xanh ước mơ \n" +
                "Ngày lại ngày qua phố mắt ngây thơ chưa vương sầu nhớ \n" +
                "Ơi cuộc đời như ngàn ý thơ \n" +
                "Đẹp như đoá hoa hồng sớm mai. \n" +
                "\n" +
                "Dịu dàng tựa cơn gió lướt nhẹ qua cho em hát ca \n" +
                "Bồng bềnh tựa làn mây đưa nắng về tô hồng đôi má \n" +
                "Ơi cuộc đời như ngàn lá hoa \n" +
                "Cầm tay bước quên ngày tháng qua. \n" +
                "\n" +
                "[ĐK:] \n" +
                "Ôi bao la trời mây cho em nồng say vui cười từng ngày \n" +
                "Tung tăng trên đường xa con tim hòa ca trong cuộc đời này \n" +
                "Trao cho nhau ngày mai cho nhau vòng tay không còn đọa đày \n" +
                "Đôi chân son nhẹ nâng mênh mông một cõi đất trời thênh thang.";
        mListSong.add(new Song(name, artist, duration, link, lyric));
        Log.i(TAG, mListSong.toString());

    }

    public MediaPlayer initMediaPlayerByRawId(int soundId, boolean isLooping){
        MediaPlayer player = MediaPlayer.create(mContext, soundId);
        player.setLooping(isLooping);
        return player;
    }

    public List<Song> getListSong() {
        return mListSong;
    }

    public boolean play() {
        try {
            if(mState == IDE || mState == STOPPED) {
                Song song = mListSong.get(mIndex);
                mPlayer.setDataSource(mContext, Uri.parse(song.getLink()));

                mPlayer.prepare();
                mPlayer.start();
                mState = PLAYING;
                return true;
            } else if (mState == PLAYING){
                pause();
                return false;
            } else if (mState == PAUSE) {
                mPlayer.start();
                mState = PLAYING;
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

    private void pause() {
        mPlayer.pause();
        mState = PAUSE;
    }

    public boolean next() {
        if(isShuffled) {
            mIndex = new Random().nextInt(mListSong.size());
        } else {
            mIndex = (mIndex + 1) % mListSong.size();
        }
        stop();
        return play();
    }

    public boolean back() {
        if(isShuffled) {
            mIndex = new Random().nextInt(mListSong.size());
        } else {
            if (mIndex == 0) {
                mIndex = mListSong.size();
            }
            mIndex --;
        }
        stop();
        return play();
    }

    public void stop() {
        if(mState == PLAYING || mState == PAUSE) {
            mPlayer.stop();
            mPlayer.reset();
            mState = STOPPED;
        }
    }

    public void setShuffle(boolean stateShuffle) {
        isShuffled = stateShuffle;
    }

    public Song getCurrentSong() {
        return mListSong.get(mIndex);
    }

    public String getIndexText() {
        return (mIndex + 1) + "/" + mListSong.size();
    }

    public String getDuration(int duration) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("mm:ss");
        return dateFormat.format(new Date(duration));  //Chuyển milis thành phút/giây
    }

    public boolean play(int position) {
        stop();
        mIndex = position;
        return play();
    }

    public boolean isStarted() {
        return mState == PLAYING || mState == PAUSE;
    }

    public String getCurrentTimeText() {
        int curentTime = mPlayer.getCurrentPosition(); //Lấy được vị trí hiện tại đã chơi đến đâu
        int totalTime = mListSong.get(mIndex).getDuration();

        return getDuration(curentTime) + "/" + getDuration(totalTime);
    }

    public int getDurationSong() {
        return mListSong.get(mIndex).getDuration();
    }

    public int getCurrentTime() {
        return mPlayer.getCurrentPosition();
    }

    public void seek(int progress) {
        mPlayer.seekTo(progress);
    }

    public void loopAll() {
        mPlayer.setLooping(false);
    }

    public void loopOne() {
        mPlayer.setLooping(true);
    }

    public void loopOff() {

    }
    @Override
    public void onCompletion(MediaPlayer mediaPlayer) {
        if (ListMusicFragment.whatLoop == ListMusicFragment.LEVEL_LOOP_ALL) {
            next();
        }
    }
}
