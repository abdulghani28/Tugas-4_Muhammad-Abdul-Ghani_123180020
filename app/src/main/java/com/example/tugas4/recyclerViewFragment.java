package com.example.tugas4;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link recyclerViewFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class recyclerViewFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public recyclerViewFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment recyclerViewFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static recyclerViewFragment newInstance(String param1, String param2) {
        recyclerViewFragment fragment = new recyclerViewFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        RecyclerView playerRecycler;

        ArrayList<MainModel> mainModels;
        MainAdapter mainAdapter;

        View view = inflater.inflate(R.layout.fragment_recycler_view, container,false);

        playerRecycler = view.findViewById(R.id.rv_php);

        Integer[] playerFoto = {R.drawable.degea,
                R.drawable.maguire,
                R.drawable.fernandes,
                R.drawable.greenwood,
                R.drawable.martial,
                R.drawable.pogba,
                R.drawable.rashford,
                R.drawable.shaw,
                R.drawable.wan
        };

        String[] playerName = {"David De Gea", "Harry Maguire", "Bruno Fernandes", "Mason Greenwood", "Anthony Martial", "Paul Pogba", "Marcus Rashford", "Luke Shaw", "Aaron Wan-Bissaka"};

        String[] playerDetail = {
                "David De Gea blossomed into one of the top goalkeepers in the world after joining United in 2011.\n" +
                        "\n" +
                        "When Sir Alex Ferguson signed the Spaniard to replace the outgoing Edwin van der Sar, the youngster was immediately thrust into the limelight. However, having already helped Atletico Madrid to win the Europa League in 2009/10 and the UEFA Super Cup thereafter, he was more than up to the task. His first season at United saw him unfairly scrutinised by sections of the media at every turn, but he adapted to the English game to show his true colours. ",
                "Harry Maguire has risen through the leagues to establish himself as one of the most reliable centre-backs in the game.\n" +
                        "\n" +
                        "However, his route to the top has not always been an easy one. ",
                "Bruno Fernandes took an unusual path to the top when compared to other Portuguese talents who have served Manchester United.\n" +
                        "\n" +
                        "While the likes of Cristiano Ronaldo and Nani made their names in Portugal, Fernandes spent the first five years of his career in Italy.",
                "An exciting striker who has been well ahead of schedule in terms of his progress through the ranks at United and has made a huge impact in 2019/20.\n" +
                        "\n" +
                        "Mason was top scorer in the Under-18 Premier League North in 2017/18, while still a schoolboy and being eligible for Under-16 level.",
                "A forward who is often compared to Premier League legend Thierry Henry, another former Monaco man, Anthony Martial has all of the tools needed to shine at Manchester United.\n" +
                        "\n" +
                        "Martial began his career in the junior ranks of CO Les Ulis, where Henry and ex-Red Patrice Evra both started their illustrious careers. At the age of 14, he joined Lyon and became a regular for the France youth sides, earning a reputation as one of Europe’s hottest prospects. His excellent potential was so obvious that Monaco paid €5million for his signature in a transfer that rocked French football.",
                "Paul Pogba needs no introduction to Manchester United fans, having learned his trade at the club before blossoming into a world-class midfielder at Juventus.\n" +
                        "\n" +
                        "Born in Lagny-sur-Marne on the outskirts of Paris, he started to attract attention as a schoolboy with Le Havre, before United eventually won the race for his signature. Paul went on to become a key member of the Under-18s team, and was a driving force in the FA Youth Cup-winning side of 2011.",
                "Marcus Rashford was thrust into the senior spotlight in February 2016 – with spectacular results – and has not looked back since.\n" +
                        "\n" +
                        "The homegrown youth product has already come such a long way in a short time and having the happy knack of scoring on his debuts has helped. He netted twice against Midtjylland when thrust into the spotlight in a Europa League tie and followed it up with a brace against Arsenal on his Premier League bow.",
                "Luke Shaw joined Manchester United from Southampton in June 2014, making him one of the Reds’ longest-serving players.\n" +
                        "\n" +
                        "The talented defender’s Southampton career began in 2004, when he joined the south-coast outfit as a 10-year-old, after being released by boyhood favourites Chelsea.",
                "Aaron Wan-Bissaka became Manchester United’s second signing of the summer transfer window in June 2019 when he joined from Crystal Palace.\n" +
                        "\n" +
                        "The talented England Under-21 international took to Premier League life like a duck to water at Palace."
        };

        mainModels = new ArrayList<>();
        for (int i = 0; i<playerFoto.length; i++){
            MainModel model = new MainModel(playerFoto[i], playerName[i], playerDetail[i]);
            mainModels.add(model);
        }

        LinearLayoutManager layoutManager = new LinearLayoutManager(
                getContext(), LinearLayoutManager.HORIZONTAL, false
        );

        playerRecycler.setLayoutManager(layoutManager);
        playerRecycler.setItemAnimator(new DefaultItemAnimator());


        mainAdapter = new MainAdapter(mainModels,getContext());

        playerRecycler.setAdapter(mainAdapter);
        return view;
    }
}