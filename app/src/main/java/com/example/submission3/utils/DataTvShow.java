package com.example.submission3.utils;

import com.example.submission3.data.source.local.entity.TvShowEntity;
import com.example.submission3.data.source.remote.response.TvShowResponse;

import java.util.ArrayList;

public class DataTvShow {
    public static ArrayList<TvShowEntity> generateDummyTvShow() {

        ArrayList<TvShowEntity> tvShow = new ArrayList<>();

        tvShow.add(new TvShowEntity("t1",
                "Arrow",
                "Crime, Drama, Mystery, Action, Adventure",
                "42m",
                "Spoiled billionaire playboy Oliver Queen is missing and presumed dead when his yacht is lost at sea. He returns five years later a changed man, determined to clean up the city as a hooded vigilante armed with a bow.",
                "10/10/2012",
                "2012",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/gKG5QGz5Ngf8fgWpBsWtlg5L2SF.jpg",
                false));

        tvShow.add(new TvShowEntity("t2",
                "Dragon Ball",
                "Comedy, Science Fiction, Animation, Action, Adventure",
                "25m",
                "Long ago in the mountains, a fighting master known as Gohan discovered a strange boy whom he named Goku. Gohan raised him and trained Goku in martial arts until he died. The young and very strong boy was on his own, but easily managed. Then one day, Goku met a teenage girl named Bulma, whose search for the mystical Dragon Balls brought her to Goku's home. Together, they set off to find all seven and to grant her wish.",
                "02/26/1986",
                "1986",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/tZ0jXOeYBWPZ0OWzUhTlYvMF7YR.jpg",
                false));

        tvShow.add(new TvShowEntity("t3",
                "Fairy Tail",
                "Action, Adventure, Animation, Comedy, Science Fiction, Fantasy",
                "25m",
                "Lucy is a 17-year-old girl, who wants to be a full-fledged mage. One day when visiting Harujion Town, she meets Natsu, a young man who gets sick easily by any type of transportation. But Natsu isn't just any ordinary kid, he's a member of one of the world's most infamous mage guilds: Fairy Tail.",
                "10/12/2009",
                "2009",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/1T6XCwWpmg1B4jrzAlcFCnJGQVD.jpg",
                false));

        tvShow.add(new TvShowEntity("t4",
                "Family Guy",
                "Animation, Comedy",
                "22m",
                "Sick, twisted, politically incorrect and Freakin' Sweet animated series featuring the adventures of the dysfunctional Griffin family. Bumbling Peter and long-suffering Lois have three kids. Stewie (a brilliant but sadistic baby bent on killing his mother and taking over the world), Meg (the oldest, and is the most unpopular girl in town) and Chris (the middle kid, he's not very bright but has a passion for movies). The final member of the family is Brian - a talking dog and much more than a pet, he keeps Stewie in check whilst sipping Martinis and sorting through his own life issues.",
                "01/31/1999",
                "1999",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/qlClTwL0GSGZUH7xwJU5PER5wnJ.jpg",
                false));

        tvShow.add(new TvShowEntity("t5",
                "The Flash",
                "Drama, Science Fiction, Fantasy",
                "44m",
                "After a particle accelerator causes a freak storm, CSI Investigator Barry Allen is struck by lightning and falls into a coma. Months later he awakens with the power of super speed, granting him the ability to move through Central City like an unseen guardian angel. Though initially excited by his newfound powers, Barry is shocked to discover he is not the only \"meta-human\" who was created in the wake of the accelerator explosion -- and not everyone is using their new powers for good. Barry partners with S.T.A.R. Labs and dedicates his life to protect the innocent. For now, only a few close friends and associates know that Barry is literally the fastest man alive, but it won't be long before the world learns what Barry Allen has become...The Flash.",
                "10/07/2014",
                "2014",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/lJA2RCMfsWoskqlQhXPSLFQGXEJ.jpg",
                false));

        tvShow.add(new TvShowEntity("t6",
                "Gotham",
                "Drama, Crime, Science Fiction, Fantasy",
                "43m",
                "Everyone knows the name Commissioner Gordon. He is one of the crime world's greatest foes, a man whose reputation is synonymous with law and order. But what is known of Gordon's story and his rise from rookie detective to Police Commissioner? What did it take to navigate the multiple layers of corruption that secretly ruled Gotham City, the spawning ground of the world's most iconic villains? And what circumstances created them – the larger-than-life personas who would become Catwoman, The Penguin, The Riddler, Two-Face and The Joker?",
                "09/22/2014",
                "2014",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/4XddcRDtnNjYmLRMYpbrhFxsbuq.jpg",
                false));

        tvShow.add(new TvShowEntity("t7",
                "Grey's Anatomy",
                "Drama",
                "43m",
                "Follows the personal and professional lives of a group of doctors at Seattle’s Grey Sloan Memorial Hospital.",
                "03/27/2005",
                "2005",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/clnyhPqj1SNgpAdeSS6a6fwE6Bo.jpg",
                false));

        tvShow.add(new TvShowEntity("t8",
                "Naruto Shippūden",
                "Animation, Action, Adventure, Science Fiction, Fantasy",
                "25m",
                "Naruto Shippuuden is the continuation of the original animated TV series Naruto.The story revolves around an older and slightly more matured Uzumaki Naruto and his quest to save his friend Uchiha Sasuke from the grips of the snake-like Shinobi, Orochimaru. After 2 and a half years Naruto finally returns to his village of Konoha, and sets about putting his ambitions to work, though it will not be easy, as He has amassed a few (more dangerous) enemies, in the likes of the shinobi organization; Akatsuki.",
                "02/15/2007",
                "2007",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/hKkY4Hf5tDKCwVzzeo42vp1RxPQ.jpg",
                false));

        tvShow.add(new TvShowEntity("t9",
                "The Simpsons",
                "Family, Animation, Comedy",
                "22m",
                "Set in Springfield, the average American town, the show focuses on the antics and everyday adventures of the Simpson family; Homer, Marge, Bart, Lisa and Maggie, as well as a virtual cast of thousands. Since the beginning, the series has been a pop culture icon, attracting hundreds of celebrities to guest star. The show has also made name for itself in its fearless satirical take on politics, media and American life in general.",
                "12/16/1989",
                "1989",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/2IWouZK4gkgHhJa3oyYuSWfSqbG.jpg",
                false));

        tvShow.add(new TvShowEntity("t10",
                "The Walking Dead",
                "Action, Adventure, Drama, Science Fiction, Fantasy",
                "42m",
                "Sheriff's deputy Rick Grimes awakens from a coma to find a post-apocalyptic world dominated by flesh-eating zombies. He sets out to find his family and encounters many other survivors along the way.",
                "10/31/2010",
                "2010",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/rqeYMLryjcawh2JeRpCVUDXYM5b.jpg",
                false));

        return tvShow;
    }

    public static ArrayList<TvShowResponse> generateRemoteDummyTvShow() {

        ArrayList<TvShowResponse> tvShow = new ArrayList<>();

        tvShow.add(new TvShowResponse("t1",
                "Arrow",
                "Crime, Drama, Mystery, Action, Adventure",
                "42m",
                "Spoiled billionaire playboy Oliver Queen is missing and presumed dead when his yacht is lost at sea. He returns five years later a changed man, determined to clean up the city as a hooded vigilante armed with a bow.",
                "10/10/2012",
                "2012",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/gKG5QGz5Ngf8fgWpBsWtlg5L2SF.jpg"));

        tvShow.add(new TvShowResponse("t2",
                "Dragon Ball",
                "Comedy, Science Fiction, Animation, Action, Adventure",
                "25m",
                "Long ago in the mountains, a fighting master known as Gohan discovered a strange boy whom he named Goku. Gohan raised him and trained Goku in martial arts until he died. The young and very strong boy was on his own, but easily managed. Then one day, Goku met a teenage girl named Bulma, whose search for the mystical Dragon Balls brought her to Goku's home. Together, they set off to find all seven and to grant her wish.",
                "02/26/1986",
                "1986",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/tZ0jXOeYBWPZ0OWzUhTlYvMF7YR.jpg"));

        tvShow.add(new TvShowResponse("t3",
                "Fairy Tail",
                "Action, Adventure, Animation, Comedy, Science Fiction, Fantasy",
                "25m",
                "Lucy is a 17-year-old girl, who wants to be a full-fledged mage. One day when visiting Harujion Town, she meets Natsu, a young man who gets sick easily by any type of transportation. But Natsu isn't just any ordinary kid, he's a member of one of the world's most infamous mage guilds: Fairy Tail.",
                "10/12/2009",
                "2009",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/1T6XCwWpmg1B4jrzAlcFCnJGQVD.jpg"));

        tvShow.add(new TvShowResponse("t4",
                "Family Guy",
                "Animation, Comedy",
                "22m",
                "Sick, twisted, politically incorrect and Freakin' Sweet animated series featuring the adventures of the dysfunctional Griffin family. Bumbling Peter and long-suffering Lois have three kids. Stewie (a brilliant but sadistic baby bent on killing his mother and taking over the world), Meg (the oldest, and is the most unpopular girl in town) and Chris (the middle kid, he's not very bright but has a passion for movies). The final member of the family is Brian - a talking dog and much more than a pet, he keeps Stewie in check whilst sipping Martinis and sorting through his own life issues.",
                "01/31/1999",
                "1999",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/qlClTwL0GSGZUH7xwJU5PER5wnJ.jpg"));

        tvShow.add(new TvShowResponse("t5",
                "The Flash",
                "Drama, Science Fiction, Fantasy",
                "44m",
                "After a particle accelerator causes a freak storm, CSI Investigator Barry Allen is struck by lightning and falls into a coma. Months later he awakens with the power of super speed, granting him the ability to move through Central City like an unseen guardian angel. Though initially excited by his newfound powers, Barry is shocked to discover he is not the only \"meta-human\" who was created in the wake of the accelerator explosion -- and not everyone is using their new powers for good. Barry partners with S.T.A.R. Labs and dedicates his life to protect the innocent. For now, only a few close friends and associates know that Barry is literally the fastest man alive, but it won't be long before the world learns what Barry Allen has become...The Flash.",
                "10/07/2014",
                "2014",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/lJA2RCMfsWoskqlQhXPSLFQGXEJ.jpg"));

        tvShow.add(new TvShowResponse("t6",
                "Gotham",
                "Drama, Crime, Science Fiction, Fantasy",
                "43m",
                "Everyone knows the name Commissioner Gordon. He is one of the crime world's greatest foes, a man whose reputation is synonymous with law and order. But what is known of Gordon's story and his rise from rookie detective to Police Commissioner? What did it take to navigate the multiple layers of corruption that secretly ruled Gotham City, the spawning ground of the world's most iconic villains? And what circumstances created them – the larger-than-life personas who would become Catwoman, The Penguin, The Riddler, Two-Face and The Joker?",
                "09/22/2014",
                "2014",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/4XddcRDtnNjYmLRMYpbrhFxsbuq.jpg"));

        tvShow.add(new TvShowResponse("t7",
                "Grey's Anatomy",
                "Drama",
                "43m",
                "Follows the personal and professional lives of a group of doctors at Seattle’s Grey Sloan Memorial Hospital.",
                "03/27/2005",
                "2005",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/clnyhPqj1SNgpAdeSS6a6fwE6Bo.jpg"));

        tvShow.add(new TvShowResponse("t8",
                "Naruto Shippūden",
                "Animation, Action, Adventure, Science Fiction, Fantasy",
                "25m",
                "Naruto Shippuuden is the continuation of the original animated TV series Naruto.The story revolves around an older and slightly more matured Uzumaki Naruto and his quest to save his friend Uchiha Sasuke from the grips of the snake-like Shinobi, Orochimaru. After 2 and a half years Naruto finally returns to his village of Konoha, and sets about putting his ambitions to work, though it will not be easy, as He has amassed a few (more dangerous) enemies, in the likes of the shinobi organization; Akatsuki.",
                "02/15/2007",
                "2007",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/hKkY4Hf5tDKCwVzzeo42vp1RxPQ.jpg"));

        tvShow.add(new TvShowResponse("t9",
                "The Simpsons",
                "Family, Animation, Comedy",
                "22m",
                "Set in Springfield, the average American town, the show focuses on the antics and everyday adventures of the Simpson family; Homer, Marge, Bart, Lisa and Maggie, as well as a virtual cast of thousands. Since the beginning, the series has been a pop culture icon, attracting hundreds of celebrities to guest star. The show has also made name for itself in its fearless satirical take on politics, media and American life in general.",
                "12/16/1989",
                "1989",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/2IWouZK4gkgHhJa3oyYuSWfSqbG.jpg"));

        tvShow.add(new TvShowResponse("t10",
                "The Walking Dead",
                "Action, Adventure, Drama, Science Fiction, Fantasy",
                "42m",
                "Sheriff's deputy Rick Grimes awakens from a coma to find a post-apocalyptic world dominated by flesh-eating zombies. He sets out to find his family and encounters many other survivors along the way.",
                "10/31/2010",
                "2010",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/rqeYMLryjcawh2JeRpCVUDXYM5b.jpg"));

        return tvShow;
    }
}
