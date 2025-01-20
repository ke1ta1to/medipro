import { Metadata } from "next";
import "./globals.css";
import { PropsWithChildren } from "react";
import BaseLayout from "@/components/BaseLayout";

export const metadata: Metadata = {
  title: "メディプロ",
  description: "メディア情報学",
};

export default function RootLayout({ children }: PropsWithChildren) {
  return (
    <html lang="ja">
      <body>
        <BaseLayout>{children}</BaseLayout>
      </body>
    </html>
  );
}
