package com.example.submission3.utils;

import com.example.submission3.data.source.local.entity.MovieEntity;
import com.example.submission3.data.source.remote.response.MovieResponse;

import java.util.ArrayList;

public class DataMovie {
    public static ArrayList<MovieEntity> generateDummyMovie() {

        ArrayList<MovieEntity> movie = new ArrayList<>();

        movie.add(new MovieEntity("m1",
                "A Star is Born",
                "Drama, Romance, Music",
                "2h 16m",
                "Seasoned musician Jackson Maine discovers — and falls in love with — struggling artist Ally. She has just about given up on her dream to make it big as a singer — until Jack coaxes her into the spotlight. But even as Ally's career takes off, the personal side of their relationship is breaking down, as Jack fights an ongoing battle with his own internal demons.",
                "10/05/2018",
                "2018",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/afYn8yJngkM7fS7zEtURWbgvccD.jpg",
                false));

        movie.add(new MovieEntity("m2",
                "Alita: Battle Angel",
                "Action, Science Fiction, Adventure",
                "2h 2m",
                "When Alita awakens with no memory of who she is in a future world she does not recognize, she is taken in by Ido, a compassionate doctor who realizes that somewhere in this abandoned cyborg shell is the heart and soul of a young woman with an extraordinary past.",
                "02/14/2019",
                "2019",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/xRWht48C2V8XNfzvPehyClOvDni.jpg",
                false));

        movie.add(new MovieEntity("m3",
                "Aquaman",
                "Action, Adventure, Fantasy",
                "2h 23m",
                "Once home to the most advanced civilization on Earth, Atlantis is now an underwater kingdom ruled by the power-hungry King Orm. With a vast army at his disposal, Orm plans to conquer the remaining oceanic people and then the surface world. Standing in his way is Arthur Curry, Orm's half-human, half-Atlantean brother and true heir to the throne.",
                "12/21/2018",
                "2018",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/5Kg76ldv7VxeX9YlcQXiowHgdX6.jpg",
                false));

        movie.add(new MovieEntity("m4",
                "Bohemian Rhapsody",
                "Music, Drama, History",
                "2h 15m",
                "Singer Freddie Mercury, guitarist Brian May, drummer Roger Taylor and bass guitarist John Deacon take the music world by storm when they form the rock 'n' roll band Queen in 1970. Hit songs become instant classics. When Mercury's increasingly wild lifestyle starts to spiral out of control, Queen soon faces its greatest challenge yet – finding a way to keep the band together amid the success and excess.",
                "11/02/2018",
                "2018",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/lHu1wtNaczFPGFDTrjCSzeLPTKN.jpg",
                false));

        movie.add(new MovieEntity("m5",
                "Fantastic Beasts: The Crimes of Grindelwald",
                "Adventure, Fantasy, Drama",
                "2h 14m",
                "Gellert Grindelwald has escaped imprisonment and has begun gathering followers to his cause—elevating wizards above all non-magical beings. The only one capable of putting a stop to him is the wizard he once called his closest friend, Albus Dumbledore. However, Dumbledore will need to seek help from the wizard who had thwarted Grindelwald once before, his former student Newt Scamander, who agrees to help, unaware of the dangers that lie ahead. Lines are drawn as love and loyalty are tested, even among the truest friends and family, in an increasingly divided wizarding world.",
                "11/16/2018",
                "2018",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/fMMrl8fD9gRCFJvsx0SuFwkEOop.jpg",
                false));

        movie.add(new MovieEntity("m6",
                "How to Train Your Dragon: The Hidden World",
                "Animation, Family, Adventure",
                "1h 44m",
                "As Hiccup fulfills his dream of creating a peaceful dragon utopia, Toothless’ discovery of an untamed, elusive mate draws the Night Fury away. When danger mounts at home and Hiccup’s reign as village chief is tested, both dragon and rider must make impossible decisions to save their kind.",
                "02/22/2019",
                "2019",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/xvx4Yhf0DVH8G4LzNISpMfFBDy2.jpg",
                false));

        movie.add(new MovieEntity("m7",
                "Avengers: Infinity War",
                "Adventure, Action, Science Fiction",
                "2h 29m",
                "As the Avengers and their allies have continued to protect the world from threats too large for any one hero to handle, a new danger has emerged from the cosmic shadows: Thanos. A despot of intergalactic infamy, his goal is to collect all six Infinity Stones, artifacts of unimaginable power, and use them to inflict his twisted will on all of reality. Everything the Avengers have fought for has led up to this moment - the fate of Earth and existence itself has never been more uncertain.",
                "04/27/2018",
                "2018",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/7WsyChQLEftFiDOVTGkv3hFpyyt.jpg",
                false));

        movie.add(new MovieEntity("m8",
                "Ralph Breaks the Internet",
                "Family, Animation, Comedy, Adventure",
                "1h 52m",
                "Video game bad guy Ralph and fellow misfit Vanellope von Schweetz must risk it all by traveling to the World Wide Web in search of a replacement part to save Vanellope's video game, Sugar Rush. In way over their heads, Ralph and Vanellope rely on the citizens of the internet — the netizens — to help navigate their way, including an entrepreneur named Yesss, who is the head algorithm and the heart and soul of trend-making site BuzzzTube.",
                "11/21/2018",
                "2018",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/qEnH5meR381iMpmCumAIMswcQw2.jpg",
                false));

        movie.add(new MovieEntity("m9",
                "Spider-Man: Into the Spider-Verse",
                "Action, Adventure, Animation, Science Fiction, Comedy",
                "1h 57m",
                "Miles Morales is juggling his life between being a high school student and being a spider-man. When Wilson \"Kingpin\" Fisk uses a super collider, others from across the Spider-Verse are transported to this dimension.",
                "12/14/2018",
                "2018",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/iiZZdoQBEYBv6id8su7ImL0oCbD.jpg",
                false));

        movie.add(new MovieEntity("m10",
                "T-34",
                "War, Action, Drama, History",
                "2h 19m",
                "In 1944, a courageous group of Russian soldiers managed to escape from German captivity in a half-destroyed legendary T-34 tank. Those were the times of unforgettable bravery, fierce fighting, unbreakable love, and legendary miracles.",
                "01/01/2019",
                "2019",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/jqBIHiSglRfNxjh1zodHLa9E7zW.jpg",
                false));

        return movie;
    }

    public static ArrayList<MovieResponse> generateRemoteDummyMovie() {

        ArrayList<MovieResponse> movie = new ArrayList<>();

        movie.add(new MovieResponse("m1",
                "A Star is Born",
                "Drama, Romance, Music",
                "2h 16m",
                "Seasoned musician Jackson Maine discovers — and falls in love with — struggling artist Ally. She has just about given up on her dream to make it big as a singer — until Jack coaxes her into the spotlight. But even as Ally's career takes off, the personal side of their relationship is breaking down, as Jack fights an ongoing battle with his own internal demons.",
                "10/05/2018",
                "2018",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/afYn8yJngkM7fS7zEtURWbgvccD.jpg"));

        movie.add(new MovieResponse("m2",
                "Alita: Battle Angel",
                "Action, Science Fiction, Adventure",
                "2h 2m",
                "When Alita awakens with no memory of who she is in a future world she does not recognize, she is taken in by Ido, a compassionate doctor who realizes that somewhere in this abandoned cyborg shell is the heart and soul of a young woman with an extraordinary past.",
                "02/14/2019",
                "2019",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/xRWht48C2V8XNfzvPehyClOvDni.jpg"));

        movie.add(new MovieResponse("m3",
                "Aquaman",
                "Action, Adventure, Fantasy",
                "2h 23m",
                "Once home to the most advanced civilization on Earth, Atlantis is now an underwater kingdom ruled by the power-hungry King Orm. With a vast army at his disposal, Orm plans to conquer the remaining oceanic people and then the surface world. Standing in his way is Arthur Curry, Orm's half-human, half-Atlantean brother and true heir to the throne.",
                "12/21/2018",
                "2018",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/5Kg76ldv7VxeX9YlcQXiowHgdX6.jpg"));

        movie.add(new MovieResponse("m4",
                "Bohemian Rhapsody",
                "Music, Drama, History",
                "2h 15m",
                "Singer Freddie Mercury, guitarist Brian May, drummer Roger Taylor and bass guitarist John Deacon take the music world by storm when they form the rock 'n' roll band Queen in 1970. Hit songs become instant classics. When Mercury's increasingly wild lifestyle starts to spiral out of control, Queen soon faces its greatest challenge yet – finding a way to keep the band together amid the success and excess.",
                "11/02/2018",
                "2018",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/lHu1wtNaczFPGFDTrjCSzeLPTKN.jpg"));

        movie.add(new MovieResponse("m5",
                "Fantastic Beasts: The Crimes of Grindelwald",
                "Adventure, Fantasy, Drama",
                "2h 14m",
                "Gellert Grindelwald has escaped imprisonment and has begun gathering followers to his cause—elevating wizards above all non-magical beings. The only one capable of putting a stop to him is the wizard he once called his closest friend, Albus Dumbledore. However, Dumbledore will need to seek help from the wizard who had thwarted Grindelwald once before, his former student Newt Scamander, who agrees to help, unaware of the dangers that lie ahead. Lines are drawn as love and loyalty are tested, even among the truest friends and family, in an increasingly divided wizarding world.",
                "11/16/2018",
                "2018",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/fMMrl8fD9gRCFJvsx0SuFwkEOop.jpg"));

        movie.add(new MovieResponse("m6",
                "How to Train Your Dragon: The Hidden World",
                "Animation, Family, Adventure",
                "1h 44m",
                "As Hiccup fulfills his dream of creating a peaceful dragon utopia, Toothless’ discovery of an untamed, elusive mate draws the Night Fury away. When danger mounts at home and Hiccup’s reign as village chief is tested, both dragon and rider must make impossible decisions to save their kind.",
                "02/22/2019",
                "2019",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/xvx4Yhf0DVH8G4LzNISpMfFBDy2.jpg"));

        movie.add(new MovieResponse("m7",
                "Avengers: Infinity War",
                "Adventure, Action, Science Fiction",
                "2h 29m",
                "As the Avengers and their allies have continued to protect the world from threats too large for any one hero to handle, a new danger has emerged from the cosmic shadows: Thanos. A despot of intergalactic infamy, his goal is to collect all six Infinity Stones, artifacts of unimaginable power, and use them to inflict his twisted will on all of reality. Everything the Avengers have fought for has led up to this moment - the fate of Earth and existence itself has never been more uncertain.",
                "04/27/2018",
                "2018",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/7WsyChQLEftFiDOVTGkv3hFpyyt.jpg"));

        movie.add(new MovieResponse("m8",
                "Ralph Breaks the Internet",
                "Family, Animation, Comedy, Adventure",
                "1h 52m",
                "Video game bad guy Ralph and fellow misfit Vanellope von Schweetz must risk it all by traveling to the World Wide Web in search of a replacement part to save Vanellope's video game, Sugar Rush. In way over their heads, Ralph and Vanellope rely on the citizens of the internet — the netizens — to help navigate their way, including an entrepreneur named Yesss, who is the head algorithm and the heart and soul of trend-making site BuzzzTube.",
                "11/21/2018",
                "2018",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/qEnH5meR381iMpmCumAIMswcQw2.jpg"));

        movie.add(new MovieResponse("m9",
                "Spider-Man: Into the Spider-Verse",
                "Action, Adventure, Animation, Science Fiction, Comedy",
                "1h 57m",
                "Miles Morales is juggling his life between being a high school student and being a spider-man. When Wilson \"Kingpin\" Fisk uses a super collider, others from across the Spider-Verse are transported to this dimension.",
                "12/14/2018",
                "2018",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/iiZZdoQBEYBv6id8su7ImL0oCbD.jpg"));

        movie.add(new MovieResponse("m10",
                "T-34",
                "War, Action, Drama, History",
                "2h 19m",
                "In 1944, a courageous group of Russian soldiers managed to escape from German captivity in a half-destroyed legendary T-34 tank. Those were the times of unforgettable bravery, fierce fighting, unbreakable love, and legendary miracles.",
                "01/01/2019",
                "2019",
                "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/jqBIHiSglRfNxjh1zodHLa9E7zW.jpg"));

        return movie;
    }
}
