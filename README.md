#To do List
1. buat input masukin nama player,senjata : done
2. bikin wave : done
3. bikin pertempuran : done
4. bikin level : done
6. defend belum ngaruh :done
7. damage senjata belum ngaruh : done


## 4 Pilar OOP
1. Inheritance (Pewarisan) : done
2. Polimorfisme (overloading & overriding)
3. Abstraction (abstract class) : done
4. Encapsulasi (getter & setter) : done



Game Petualangan: Buat game petualangan berbasis teks di mana pemain dapat menjelajahi dunia fiksi, berinteraksi dengan karakter, mengumpulkan item, dan menyelesaikan misi. Anda dapat membuat kelas seperti Player, Character, Item, dan GameEngine untuk mengatur logika permainan.




Tentu! Proyek game petualangan berbasis teks adalah aplikasi sederhana yang memungkinkan pemain menjelajahi dunia fiksi, berinteraksi dengan karakter, mengumpulkan item, dan menyelesaikan misi. Di bawah ini adalah penjelasan lebih detail tentang komponen utama yang dapat ada dalam proyek tersebut:

    Kelas Player:
        Kelas ini merepresentasikan karakter pemain dalam game.
        Atribut-atribut yang mungkin dimiliki oleh kelas Player antara lain nama, level, poin kesehatan (health points/HP), poin kekuatan (strength points/SP), dan item yang dimiliki.
        Metode-metode dalam kelas ini dapat melibatkan pengaturan atribut pemain, seperti mengubah nama, meningkatkan level, mengurangi HP atau SP, atau mengelola inventaris item.

    Kelas Character:
        Kelas ini merepresentasikan karakter dalam game, selain pemain.
        Karakter-karakter ini bisa berfungsi sebagai musuh yang harus dikalahkan, NPC (Non-Player Character) yang memberikan misi atau informasi, atau karakter lain yang berinteraksi dengan pemain.
        Atribut-atribut yang mungkin dimiliki oleh kelas Character antara lain nama, level, HP, SP, dan item yang dimiliki.
        Metode-metode dalam kelas ini dapat mencakup tindakan karakter, seperti menyerang pemain, memberikan hadiah, atau memberikan petunjuk.

    Kelas Item:
        Kelas ini merepresentasikan item atau barang dalam game yang dapat dikumpulkan atau digunakan oleh pemain.
        Atribut-atribut yang mungkin dimiliki oleh kelas Item antara lain nama, deskripsi, atribut tambahan yang diberikan kepada pemain (seperti peningkatan HP atau SP), atau tipe item (senjata, armor, potion, dll.).
        Metode-metode dalam kelas ini dapat mencakup fungsi-fungsi seperti mengambil item, menggunakan item, atau menghapus item dari inventaris.

    Kelas GameEngine:
        Kelas ini bertanggung jawab atas logika permainan dan mengatur alur permainan.
        Metode-metode dalam kelas ini akan mengatur interaksi antara pemain, karakter, dan item, serta mengelola situasi seperti pertempuran, pencarian, dan pengumpulan item.
        Ketergantungan pada penggunaan input dari pemain, baik melalui keyboard atau melalui antarmuka baris perintah, juga dapat diimplementasikan di kelas ini.

Dalam proyek ini, Anda dapat mengembangkan lebih lanjut dengan menambahkan fitur-fitur seperti peta, lokasi yang dapat dieksplorasi, tugas-tugas atau misi yang harus diselesaikan, sistem peningkatan level, dan lain-lain. Anda juga dapat mengimplementasikan logika tambahan, seperti mekanisme pertarungan, keberuntungan dalam pencarian item, atau sistem interaksi yang lebih kompleks antara pemain dan karakter.

Pastikan untuk merencanakan desain kelas yang baik, menggunakan prinsip-prinsip OOP seperti enkapsulasi, pewarisan, dan polimorfisme untuk membuat kode lebih terstruktur dan mudah diubah atau dikembangkan di masa mendatang.